package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;


@ControllerAdvice
public class GlobalControllerAdvice {

    /* 모든 페이지에 직책 데이터 넘겨주기 */
    @ModelAttribute
    public void addUserRole(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        AuthDetails authDetails = (AuthDetails) userDetails;

        if(authDetails != null) {
            String role = authDetails.getLoginEmployeeDto().getEmployeeRole().getRoleName();
            List<String> allowedRoles = Arrays.asList("대표", "인사팀장", "인사팀원", "부서장", "팀장");
            List<String> allowedHr = Arrays.asList("대표", "인사팀장", "인사팀원");
            List<String> allowedHrL = Arrays.asList("대표", "인사팀장");

            model.addAttribute("role", role);
            model.addAttribute("allowedRoles", allowedRoles);
            model.addAttribute("allowedHr", allowedHr);
            model.addAttribute("allowedHrL", allowedHrL);
        }
    }
}
