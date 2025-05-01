package com.poi.hr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.dept.DepPositionEmployee;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.vacation.enums.LeaveType;
import com.poi.hr.dto.approval.*;
import com.poi.hr.service.*;
import com.poi.hr.service.approval.ApprovalEmpLeaveService;
import com.poi.hr.service.approval.ApprovalLineService;
import com.poi.hr.service.approval.ApprovalService;
import com.poi.hr.service.approval.ApprovalVacService;
import com.poi.hr.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    private final ApprovalService approvalService;
    private final ApprovalEmpLeaveService approvalEmpLeaveService;
    private final ApprovalVacService approvalVacService;
    private final ApprovalLineService approvalLineService;
    private final DeptService deptService;

    public ApprovalController(ApprovalService approvalService, ApprovalEmpLeaveService approvalEmpLeaveService, ApprovalVacService approvalVacService, ApprovalLineService approvalLineService, DeptService deptService) {
        this.approvalService = approvalService;
        this.approvalEmpLeaveService = approvalEmpLeaveService;
        this.approvalVacService = approvalVacService;
        this.approvalLineService = approvalLineService;
        this.deptService = deptService;
    }

    /* 출퇴근 탭 */
//    @GetMapping("/approval/detail")
//    public String showApprovalDocsList(Model model) {
//        model.addAttribute("title", "결재 내역 상세");
//        return "approval/detail";
//    }

    @GetMapping("/choice")
    public String saveApproval() {
        return "approval/choice";
    }

    @GetMapping("/save/empleave")
    public String showApprovalEmpLeave(Model model) throws JsonProcessingException {
        model.addAttribute("approvalEmpLeaveSaveDto", new ApprovalEmpLeaveSaveDto());

        List<Dept> deptList = deptService.findAllDepts();
        List<DepPositionEmployee> all = deptService.findAllWithDeptAndEmployee();

        Map<String, List<EmployeeDto>> deptEmpMap = new HashMap<>();
        for (DepPositionEmployee dpe : all) {
            String deptIdStr = String.valueOf(dpe.getDept().getDeptId());
            EmployeeDto empDto = new EmployeeDto(
                    dpe.getEmployee().getEmployeeId(),
                    dpe.getEmployee().getEmployeeName()
            );
            deptEmpMap.computeIfAbsent(deptIdStr, k -> new ArrayList<>()).add(empDto);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String deptEmpMapJson = objectMapper.writeValueAsString(deptEmpMap);

        model.addAttribute("deptEmpMap", deptEmpMap);  // Thymeleaf select 옵션용
        model.addAttribute("deptEmpMapJson", deptEmpMapJson);  // JavaScript에서 쓸 JSON 문자열
        model.addAttribute("approvalEmpLeaveViewDto", new ApprovalEmpLeaveViewDto(List.of(LeaveType.values()), deptList));
        return "approval/save/empleave";
    }


    @PostMapping("/save/empleave")
    public String SaveEmpLeave(@ModelAttribute ApprovalEmpLeaveSaveDto approvalEmpLeaveSaveDto) {
        approvalEmpLeaveService.saveApprovalEmpLeave(approvalEmpLeaveSaveDto);
        approvalLineService.saveApprovalLine(approvalEmpLeaveSaveDto.getApprovalLineList());
        return "redirect:/approval/list";
    }

    @GetMapping("/list")
    public String showApprovalList(Model model) {
        int currentUserId = SecurityUtil.getCurrentEmployeeId();
        List<ApprovalListDto> approvalList = approvalService.findApprovalsByWriter(currentUserId);
        model.addAttribute("approvalList", approvalList);
        return "approval/list";
    }

    @GetMapping("/detail/{id}")
    public String showApprovalDetail(Model model, @PathVariable int id) {
        ApprovalDetailDto approvalDetailDto = approvalService.findById(id);

        switch (approvalDetailDto.getDocTypeCode()) {
            case "LEAVE_REQUEST":
                model.addAttribute("approvalDoc", approvalEmpLeaveService.findApprovalEmpLeaveById(id));
                break;
            case "VACATION_REQUEST":
                model.addAttribute("approvalDoc", approvalVacService.findApprovalVacById(id));
                break;
            default:
                throw new IllegalArgumentException("결재 문서가 존재하지 않습니다.");
        }

        return "approval/detail";
    }

    /* 내게 온 결재 목록 출력하기 */
    @GetMapping("/inboxList")
    public String showMyApprovalList(Model model) {
        List<ApprovalMyListDto> approvalMyList = approvalService.findMyApprovals();
        model.addAttribute("approvalMyList", approvalMyList);
        return "approval/inboxList";
    }

    /* 내게 온 결재 상세보기 출력 */
    @GetMapping("/inbox/detail/{approvalDocId}")
    public String showInboxDetail(@PathVariable int approvalDocId, Model model) {
        ApprovalDetailDto approvalDetailDto = approvalService.findById(approvalDocId);

        switch (approvalDetailDto.getDocTypeCode()) {
            case "LEAVE_REQUEST":
                model.addAttribute("approvalDoc", approvalEmpLeaveService.findApprovalEmpLeaveById(approvalDocId));
                break;
            case "VACATION_REQUEST":
                model.addAttribute("approvalDoc", approvalVacService.findApprovalVacById(approvalDocId));
                break;
            default:
                throw new IllegalArgumentException("결재 문서가 존재하지 않습니다.");
        }

        return "approval/mylistDetail";
    }

    /* 승인/반려 버튼 눌렀을 때 처리 */
    @PostMapping("/inbox/detail/{approvalDocId}")
    @ResponseBody
    public ResponseEntity<?> processApproval(
            @PathVariable int approvalDocId,
            @RequestBody ApprovalActionRequest request,
            Authentication authentication) {

        int approverId = SecurityUtil.getCurrentEmployeeId();
        approvalService.processApprovalAction(approvalDocId, approverId, request);

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/mylist/{id}")
//    public String showMylistDetail(@PathVariable("id") int id, Model model) {
//        ApprovalEmpLeaveResponseDto dto = approvalEmpLeaveService.findApprovalEmpLeaveById(id);  // ← 여기 수정
//
//        model.addAttribute("docType", dto.getDocTypeName());
//        model.addAttribute("approvalTitle", dto.getApprovalTitle());
//        model.addAttribute("approvalContent", dto.getApprovalContent());
//        model.addAttribute("approvalReason", dto.getApprovalReason());
//        model.addAttribute("leaveStartDate", dto.getVacReqStart());
//        model.addAttribute("leaveEndDate", dto.getVacReqEnd());
//        model.addAttribute("leaveType", dto.getLeaveType());
//
//        return "approval/mylistDetail";
//    }


}