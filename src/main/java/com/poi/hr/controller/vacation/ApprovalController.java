package com.poi.hr.controller.vacation;

import com.poi.hr.dto.vacation.ApprovalDTO;
import com.poi.hr.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/poihr/approval")
public class ApprovalController {

    private final ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ApprovalDTO> approvalDocs = approvalService.getAlldocuments();
        model.addAttribute("approvalDocs", approvalDocs);
        return "/vacation/approvalTest2";
    }
}
