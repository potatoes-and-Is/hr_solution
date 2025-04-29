package com.poi.hr.controller;


import com.poi.hr.dto.LoginEmployeeDto;
import com.poi.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginEmployeeDto> test(@PathVariable int id) {
        System.out.println("컨트롤러 접근");
        LoginEmployeeDto loginEmployeeDto = employeeService.findById(id);

        if (loginEmployeeDto == null) {
            return ResponseEntity.status(500).body(null);
        } else{
            return ResponseEntity.ok().body(loginEmployeeDto);
        }
    }
}
