package com.poi.hr.controller;

import com.poi.hr.dto.vacation.ApprovalEmpAttendanceSaveDTO;
import com.poi.hr.dto.vacation.ApprovalEmpVacationSaveDTO;
import com.poi.hr.dto.vacation.ApprovalViewDTO;
import com.poi.hr.dto.vacation.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.service.ApprovalDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/approval")
public class ApprovalDocController {

    @Autowired
    private ApprovalDocService approvalDocService; // ApprovalService 사용

    @GetMapping("/retirementsave")
    public String showRetirementForm(Model model) {
        ApprovalViewDTO viewDto = approvalDocService.getLeaveFormData();

        // ✅ HTML에서 참조하는 이름으로 정확히 맞춰주기
        model.addAttribute("approvalViewDTO", viewDto);
        model.addAttribute("approvalEmpRetireSaveDTO", new ApprovalEmpRetireSaveDTO());

        return "approval/retirementsave";
    }

    @GetMapping("/vacationsave")
    public String showVacationForm(Model model) {
        ApprovalViewDTO viewDto = approvalDocService.getLeaveFormData();

        // ✅ HTML에서 참조하는 이름으로 정확히 맞춰주기
        model.addAttribute("approvalViewDTO", viewDto);
        model.addAttribute("approvalEmpVacationSaveDTO", new ApprovalEmpVacationSaveDTO());

        return "approval/vacationsave";
    }

    @GetMapping("/attendancesave")
    public String showAttendanceForm(Model model) {
        ApprovalViewDTO viewDto = approvalDocService.getLeaveFormData();

        // ✅ HTML에서 참조하는 이름으로 정확히 맞춰주기
        model.addAttribute("approvalViewDTO", viewDto);
        model.addAttribute("approvalEmpAttendanceSaveDTO", new ApprovalEmpAttendanceSaveDTO());

        return "approval/attendanceFixsave";
    }

    @GetMapping("/by-department")
    @ResponseBody  // ✅ JSON 응답 보낼 때 필요함!!
    public List<EmployeeRequestDTO> getEmployeesByDepartment(@RequestParam String department) {
        return approvalDocService.getEmployeesByDepartment(department);  // static 제거된 메서드 호출
    }


    // 직원 상세 정보를 반환
    @GetMapping("/{employeeId}")
    public EmployeeRequestDTO getEmployeeDetail(@PathVariable int employeeId) {
        return approvalDocService.getEmployeeDetail(employeeId);
    }

    // 다음 직원 번호를 반환
    @GetMapping("/next-employee-number")
    public int getNextEmployeeNumber() {
        return approvalDocService.getNextEmployeeNumber();
    }

}




