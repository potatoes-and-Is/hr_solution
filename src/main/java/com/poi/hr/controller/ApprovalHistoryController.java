package com.poi.hr.controller;

import com.poi.hr.dto.approval.ApprovalHistorySaveDto;
import com.poi.hr.service.ApprovalHistoryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poihr/approval/history")
public class ApprovalHistoryController {

    private final ApprovalHistoryService approvalHistoryService;

    public ApprovalHistoryController(ApprovalHistoryService approvalHistoryService) {
        this.approvalHistoryService = approvalHistoryService;
    }

    @GetMapping("/save")
    public String saveApprovalHistory(Model model) {
        approvalHistoryService.saveApprovalHistory(new ApprovalHistorySaveDto());
        return null;
    }
}
