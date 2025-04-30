package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.dto.vacation.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.vacation.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService; // ApprovalService 사용

    @GetMapping("/leavesave")
    public String showLeaveForm(Model model) {
        ApprovalEmpRetireViewDTO viewDto = approvalService.getLeaveFormData();

        // ✅ HTML에서 참조하는 이름으로 정확히 맞춰주기
        model.addAttribute("approvalEmpRetireViewDto", viewDto);
        model.addAttribute("approvalEmpLeaveSaveDto", new ApprovalEmpRetireSaveDTO());

        return "approval/retirementsave";
    }

    @GetMapping("/by-department")
    @ResponseBody  // ✅ JSON 응답 보낼 때 필요함!!
    public List<EmployeeRequestDTO> getEmployeesByDepartment(@RequestParam String department) {
        return approvalService.getEmployeesByDepartment(department);  // static 제거된 메서드 호출
    }


    // 직원 상세 정보를 반환
    @GetMapping("/{employeeId}")
    public EmployeeRequestDTO getEmployeeDetail(@PathVariable int employeeId) {
        return approvalService.getEmployeeDetail(employeeId);
    }

    // 다음 직원 번호를 반환
    @GetMapping("/next-employee-number")
    public int getNextEmployeeNumber() {
        return approvalService.getNextEmployeeNumber();
    }

    @PostMapping("/save/leavesave")
    public String submitLeaveForm(@ModelAttribute ApprovalEmpRetireSaveDTO dto,
                                  @AuthenticationPrincipal AuthDetails authDetails) {
        // 로그인한 사용자의 ID 추출
        int employeeId = authDetails.getLoginEmployeeDto().getEmployeeId();

        // 저장 서비스 호출
        approvalService.saveLeaveApproval(dto, employeeId);

        return "redirect:/approval/leavesave?success";
    }
}




