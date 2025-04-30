package com.poi.hr.controller;

import com.poi.hr.dto.ApprovalEmpLeaveViewDTO;
import com.poi.hr.dto.ApprovalEmpLeaveSaveDTO;
import com.poi.hr.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping("/leavesave")
    public String showLeaveForm(Model model) {
        ApprovalEmpLeaveViewDTO viewDto = approvalService.getLeaveFormData();
        model.addAttribute("approvalEmpLeaveViewDto", viewDto);
        model.addAttribute("approvalEmpLeaveSaveDto", new ApprovalEmpLeaveSaveDTO());
        return "approval/leavesave";
    }

    @PostMapping("/save/leavesave")
    public String submitLeaveForm(@ModelAttribute ApprovalEmpLeaveSaveDTO dto) {
        approvalService.saveLeaveApproval(dto);
        return "redirect:/approval/leavesave?success";
    }
}
