package com.poi.hr.controller;

import com.poi.hr.dto.approval.ApprovalVacationSaveDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApprovalController {

    @GetMapping("/approval/vacation")
    public String showVacationForm(Model model) {
        model.addAttribute("approvalVacationSaveDto", new ApprovalVacationSaveDTO());
        return "approval/vacation-form";
    }
}