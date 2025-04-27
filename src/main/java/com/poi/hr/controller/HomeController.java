package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/poihr"})
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails.getAuthorities());

        model.addAttribute("title", "Home");

        // 로그인한 사용자의 이름을 model에 추가
        model.addAttribute("userName", ((AuthDetails) userDetails).getEmployeeName());

        return "index";
    }

    @GetMapping("/approval/detail")
    public String approval() {
        return "approval/detail";
    }
}
