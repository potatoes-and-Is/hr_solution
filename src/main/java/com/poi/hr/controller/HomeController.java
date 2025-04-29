package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @GetMapping({"/", "/poihr"})
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails.getAuthorities());

        model.addAttribute("title", "Home");

        AuthDetails authDetails = (AuthDetails) userDetails;
        model.addAttribute("userName", authDetails.getEmployeeName()); // 이름
        model.addAttribute("userRole", authDetails.getLoginEmployeeDto().getEmployeeRole().getRoleName()); // 직책(팀장, 팀원 등)

        // 현재 시간 (yyyy.MM.dd(E) HH:mm:ss)
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd(E) HH:mm:ss"));
        model.addAttribute("currentDateTime", currentDateTime);

        return "index";
    }

    @GetMapping("/approval/detail")
    public String approval() {
        return "approval/detail";
    }
}
