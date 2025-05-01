package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAdvice {

    @ModelAttribute("userName")
    public String injectUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) return "";

        Object principal = authentication.getPrincipal();
        if (principal instanceof AuthDetails userDetails) {
            return userDetails.getEmployeeName();
        }

        return "";
    }

}
