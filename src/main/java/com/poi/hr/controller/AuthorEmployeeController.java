package com.poi.hr.controller;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
@Validated
public class AuthorEmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public AuthorEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //관리자 페이지
    @GetMapping
    public String authorEmployeePage(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();

        model.addAttribute("employees", employees);
        return "employee/author";  // templates/employee.html 호출
    }

    //직원 추가 창 팝업
    @GetMapping("/popup")
    public String employeePopupPage() {
        return "employee/employee";
    }

    // 직원 리스트 출력
    @GetMapping("/list")
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    // 직원 추가
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody Employee employee) {
//        employeeService.applyDefaultValues(employee);
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(201).body(savedEmployee);
    }

}
