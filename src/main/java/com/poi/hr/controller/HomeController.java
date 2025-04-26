package com.poi.hr.controller;

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
        return "index";
    }



}
