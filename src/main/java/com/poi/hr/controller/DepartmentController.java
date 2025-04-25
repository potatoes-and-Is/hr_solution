package com.poi.hr.controller;

import com.poi.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
@Validated
public class DepartmentController {

    private static final Logger logger = Logger.getLogger(DepartmentController.class.getName());
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departmentInfo")
    public String departmentInfo(Model model) {
        model.addAttribute("departmentList", departmentService.getDepartmentList());
        return "department/departmentInfo";
    }
}

