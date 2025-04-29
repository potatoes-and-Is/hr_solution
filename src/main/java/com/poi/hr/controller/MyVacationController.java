package com.poi.hr.controller;

import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.service.VacationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poihr/vacation")
public class MyVacationController {

    private final VacationService vacationService;

    public MyVacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }


    @GetMapping("/my")
    public String getMyVacation(Model model) {
        int employeeId = 2;  //임시 아이디

        VacationBalanceDTO vacationInfo = vacationService.getTotalVacationInfo(employeeId);

        model.addAttribute("vacationInfo", vacationInfo);

        return "vacation/my-vacation";
    }
}
