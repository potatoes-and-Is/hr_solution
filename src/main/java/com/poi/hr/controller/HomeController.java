package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @GetMapping({"/", "/poihr"})
    public String home(Model model) {
        model.addAttribute("title", "Home");

        // 현재 날짜와 시간
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E) HH:mm");
        String formattedDateTime = now.format(formatter);
        model.addAttribute("currentDateTime", formattedDateTime);

        return "index";
    }

}
