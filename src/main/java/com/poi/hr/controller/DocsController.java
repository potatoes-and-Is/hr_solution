package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DocsController {

    /* 출퇴근 탭 */
    @GetMapping("/docslist")
    public String showApprovalDocsList(Model model) {

        model.addAttribute("title", "결재 내역 조회");
        return "approvaldocs/docslist";
    }
}
