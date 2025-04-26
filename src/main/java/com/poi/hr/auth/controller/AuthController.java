package com.poi.hr.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/auth/login")
    public String login() {
        return "common/login";
    }

//    @GetMapping("/")
//    public String root(@AuthenticationPrincipal UserDetails userDetails) {
//        System.out.println(userDetails.getAuthorities());
//
//        return "index";
//    }

    @GetMapping("/auth/fail")
    public String fail() {
        return "common/fail";
    }

    @GetMapping("/debug")
    public String debug() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("현재 로그인한 사용자: " + authentication.getName());
        authentication.getAuthorities().forEach(authority ->
                System.out.println("권한: " + authority.getAuthority())
        );
        return "debug";
    }
//    @GetMapping("/poihr")
//    public ModelAndView admin(ModelAndView modelAndView) {
//        modelAndView.setViewName("/admin/admin");
//        return modelAndView;
//    }
//
//    @GetMapping("/user/page")
//    public ModelAndView user(ModelAndView modelAndView) {
//        modelAndView.setViewName("user/user");
//        return modelAndView;
//    }
}
