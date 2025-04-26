package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poihr/vacation")
public class MyVacationController {

    //임시 아이디
    String employeeId = "2";

    @GetMapping("/my")
    public String getMyVacation(Model model) {
        model.addAttribute("employeeId", employeeId);

        //서비스로부터 연차 정보 받아오기


        return "vacation/my-vacation";
    }
}
