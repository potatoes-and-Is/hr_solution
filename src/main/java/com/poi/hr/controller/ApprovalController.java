package com.poi.hr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.dept.DepPositionEmployee;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.vacation.enums.LeaveType;
import com.poi.hr.dto.approval.*;
import com.poi.hr.service.*;
import com.poi.hr.service.approval.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.poi.hr.service.approval.ApprovalEmpLeaveService;
import com.poi.hr.service.approval.ApprovalLineService;
import com.poi.hr.service.approval.ApprovalService;
import com.poi.hr.service.approval.ApprovalVacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.poi.hr.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private final AttendService attendService;
    private final ApprovalAttendanceFixReqService approvalAttendanceFixReqService;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ApprovalController(ApprovalService approvalService, ApprovalEmpLeaveService approvalEmpLeaveService, ApprovalVacService approvalVacService, ApprovalLineService approvalLineService, DeptService deptService, AttendService attendService,  ApprovalAttendanceFixReqService approvalAttendanceFixReqService) {
        this.approvalService = approvalService;
        this.approvalEmpLeaveService = approvalEmpLeaveService;
        this.approvalVacService = approvalVacService;
        this.approvalLineService = approvalLineService;
        this.deptService = deptService;
        this.attendService = attendService;
        this.approvalAttendanceFixReqService = approvalAttendanceFixReqService;
    }

    /* 출퇴근 탭 */
//    @GetMapping("/approval/detail")
//    public String showApprovalDocsList(Model model) {
//        model.addAttribute("title", "결재 내역 상세");
//        return "approval/detail";
//    }

    public int loginUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails principal = (AuthDetails) auth.getPrincipal();
        return principal.getLoginEmployeeDto().getEmployeeId();
    }


    @GetMapping("/choice")
    public String saveApproval() {
        return "approval/choice";
    }

    /* 휴직 신청서 작성 */
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

    /* 휴직 신청서 저장 */
    @PostMapping("/save/empleave")
    public String SaveEmpLeave(@ModelAttribute ApprovalEmpLeaveSaveDto approvalEmpLeaveSaveDto) {
        approvalEmpLeaveService.saveApprovalEmpLeave(approvalEmpLeaveSaveDto, loginUserId());
        approvalLineService.saveApprovalLine(approvalEmpLeaveSaveDto.getApprovalLineList());
        return "redirect:/approval/list";
    }

    // 출퇴근 정정 데이터 받아오기
    @PostMapping("/save/fixattenddata")
    public ResponseEntity<Map<String, String>> getFixAttendData(@RequestBody Map<String, String> formData) {
        return ResponseEntity.ok().body(formData);
    }

    // 출퇴근 정정요청 폼
    @GetMapping("/save/fixattenddata")
    public String showFixAttend(
            @RequestParam("attendId") String attendId,
            @RequestParam("attendDate") String attendDate,
            @RequestParam("originCheckInTime") String originCheckInTime,
            @RequestParam("originCheckOutTime") String originCheckOutTime,
            @RequestParam("newCheckInTime") String newCheckInTime,
            @RequestParam("newCheckOutTime") String newCheckOutTime,
            Model model
    ) throws JsonProcessingException {

        ApprovalFixAttendSaveDTO dto = new ApprovalFixAttendSaveDTO();

        dto.setAttendId(Integer.parseInt(attendId));
        dto.setAttendDate(LocalDate.parse(attendDate, DATE_FORMATTER));
        dto.setOriginCheckInTime(LocalTime.parse(originCheckInTime, TIME_FORMATTER));
        dto.setOriginCheckOutTime(LocalTime.parse(originCheckOutTime, TIME_FORMATTER));
        dto.setNewCheckInTime(LocalTime.parse(newCheckInTime, TIME_FORMATTER));
        dto.setNewCheckOutTime(LocalTime.parse(newCheckOutTime, TIME_FORMATTER));
        dto.setDocTypeCode("attend_fix_request");

        model.addAttribute("ApprovalFixAttendSaveDTO", dto);
        model.addAttribute("attendId", attendId);
        model.addAttribute("attendDate", attendDate);
        model.addAttribute("originCheckInTime", originCheckInTime);
        model.addAttribute("originCheckOutTime", originCheckOutTime);
        model.addAttribute("newCheckInTime", newCheckInTime);
        model.addAttribute("newCheckOutTime", newCheckOutTime);
        model.addAttribute("docTypeCode", dto.getDocTypeCode());

        // 결재자 정보
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

        return "approval/save/fixattend";
    }

    // 출퇴근 정정요청문서 저장
    @PostMapping("/save/fixattend")
    public String saveFixAttend(@ModelAttribute ApprovalFixAttendSaveDTO approvalFixAttendSaveDto) {
        approvalAttendanceFixReqService.saveAttendanceFixReq(approvalFixAttendSaveDto, loginUserId());

        return "redirect:/approval/list";
    }

    @GetMapping("/list")
    public String showApprovalList(Model model) {
        int currentUserId = SecurityUtil.getCurrentEmployeeId();
        List<ApprovalListDto> approvalList = approvalService.findApprovalsByWriter(currentUserId);
        model.addAttribute("approvalList", approvalList);
        return "approval/list";
    }

    /* 결재 문서 상세 조회 */
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

        return "approval/testInboxDetail";
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


    @GetMapping("/mylist/{id}")
    public String showMylistDetail(@PathVariable("id") int id, Model model) {
        ApprovalEmpLeaveResponseDto dto = approvalEmpLeaveService.findApprovalEmpLeaveById(id);  // ← 여기 수정

        model.addAttribute("docType", dto.getDocTypeName());
        model.addAttribute("approvalTitle", dto.getApprovalTitle());
        model.addAttribute("approvalContent", dto.getApprovalContent());
        model.addAttribute("approvalReason", dto.getApprovalReason());
        model.addAttribute("leaveStartDate", dto.getVacReqStart());
        model.addAttribute("leaveEndDate", dto.getVacReqEnd());
        model.addAttribute("leaveType", dto.getLeaveType());

        return "approval/mylistDetail";
    }
 }