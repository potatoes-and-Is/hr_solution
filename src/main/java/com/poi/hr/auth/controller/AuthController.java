package com.poi.hr.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @GetMapping("/common/login")
    public String login() {
        return "common/login";
    }

    @GetMapping("/")
    public String root() {
        return "poihr/main";
    }

    @GetMapping
    public String fail() {
        return "common/fail";
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
