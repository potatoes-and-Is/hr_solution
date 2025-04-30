package com.poi.hr.controller;

import com.poi.hr.dto.ApprovalDto;
import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/approval")
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

    @GetMapping("/list")
    public String showApprovalList(Model model) {
        List<ApprovalListDto> approvalList = approvalService.findAllApprovals();
        model.addAttribute("approvalList", approvalList);
        return "approval/list";
    }

    @GetMapping("/detail/{id}")
    public String showApprovalDetail(Model model, @PathVariable int id) {
        ApprovalDto approvalDto = approvalService.findById(id);

        switch (approvalDto.getDocTypeName()) {
            case "휴가 신청서":
                model.addAttribute("approvalDoc", approvalService.findApprovalVacById(id));
                break;
            case "휴직 신청서":
                model.addAttribute("approvalDoc", approvalService.findApprovalEmpLeaveById(id));
                break;
            default:
                throw new IllegalArgumentException("결재 문서가 존재하지 않습니다.");
        }

        return "approval/detail";
    }

    @PostMapping("/save")
    public String saveApproval(@ModelAttribute ApprovalDto approvalDto) {
        a
    }
}
