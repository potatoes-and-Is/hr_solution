//package com.poi.hr.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping
//@Validated
//public class RetireController {
//
//    @GetMapping("/approval/leavesave")
//    public String showLeaveApprovalForm(Model model) {
//        model.addAttribute("approvalEmpLeaveSaveDto", new ApprovalEmpLeaveSaveDto()); // ⭐ 이거 추가
//        model.addAttribute("approvalEmpLeaveViewDto", approvalEmpLeaveService.getFormData()); // 부서 목록 같은 것도
//        return "employee/retire"; // -> 네 HTML 파일
//    }
//}
