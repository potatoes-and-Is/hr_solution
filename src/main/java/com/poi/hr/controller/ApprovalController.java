package com.poi.hr.controller;

import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
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
        // ApprovalService를 사용하여 부서 데이터를 가져옴
        ApprovalEmpRetireViewDTO viewDto = approvalService.getLeaveFormData();
        model.addAttribute("approvalEmpLeaveViewDto", viewDto);
        model.addAttribute("approvalEmpLeaveSaveDto", new ApprovalEmpRetireSaveDTO());
        return "approval/retirementsave"; // 화면 템플릿 이름
    }
    // 부서별 직원 목록을 반환
    @GetMapping("/by-department")
    public List<EmployeeRequestDTO> getEmployeesByDepartment(@RequestParam String department) {
        return ApprovalService.getEmployeesByDepartment(department);
    }

    // 직원 상세 정보를 반환
    @GetMapping("/{employeeId}")
    public EmployeeRequestDTO getEmployeeDetail(@PathVariable int employeeId) {
        return ApprovalService.getEmployeeDetail(employeeId);
    }

    // 다음 직원 번호를 반환
    @GetMapping("/next-employee-number")
    public int getNextEmployeeNumber() {
        return ApprovalService.getNextEmployeeNumber();
    }

    @PostMapping("/save/leavesave")
    public String submitLeaveForm(@ModelAttribute ApprovalEmpRetireSaveDTO dto) {
        approvalService.saveLeaveApproval(dto); // 저장 로직
        return "redirect:/approval/leavesave?success"; // 성공 시 리다이렉트
    }
}




