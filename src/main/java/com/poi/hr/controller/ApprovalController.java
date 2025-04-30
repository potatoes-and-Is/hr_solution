package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApprovalController {

    @GetMapping("/approval/vacation")
    public String showVacationForm() {
        return "approval/vacation-form";  // templates/approval/vacation-form.html
    }
}
