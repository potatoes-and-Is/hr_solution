package com.poi.hr.controller;

import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ApprovalController {

    private ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService) {
        this.approvalService = approvalService;
    }

    /* 출퇴근 탭 */
//    @GetMapping("/approval/detail")
//    public String showApprovalDocsList(Model model) {
//        model.addAttribute("title", "결재 내역 상세");
//        return "approval/detail";
//    }

    @GetMapping("/approval/list")
    public String showApprovalList(Model model) {
        System.out.println("!!! 컨트롤러 접근 !!!");
        List<ApprovalListDto> approvalList = approvalService.findAllApprovals();
        model.addAttribute("approvalList", approvalList);
        return "approval/list";
    }

    @GetMapping("/approval/detail/{id}")
    public String showApprovalDetail(Model model, @PathVariable int id) {
//        model.addAttribute("approval", approvalService.findById());
        return "approval/detail";
    }
}
