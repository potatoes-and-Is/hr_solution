package com.poi.hr.controller;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.dto.ResponseAuthorDTO;
import com.poi.hr.dto.UpdateEmployeeDTO;
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
        List<EmployeeRequestDTO> employees = employeeService.findAllEmployees();

        model.addAttribute("employees", employees);
        return "employee/author";  // templates/employee.html 호출
    }

    // 직원 리스트 출력
    @GetMapping("/list")
    @ResponseBody
    public List<EmployeeRequestDTO> getEmployees() {
        return employeeService.findAllEmployees();
    }

    // 직원 추가
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody EmployeeRequestDTO employee) {
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(201).body(savedEmployee);
    }

    // 직원 수정
    @PatchMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable(name = "employeeId") Integer employeeId,
            @Validated @RequestBody UpdateEmployeeDTO employeeDto) {

        employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok("수정 완료");
    }

    // 상세 조회
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeRequestDTO> getEmployeeDetail(@PathVariable("employeeId") int employeeId) {
        System.out.println("Employee ID: " + employeeId); // 디버깅용
        // 서비스 호출f
        EmployeeRequestDTO responseAuthorDTO = employeeService.getEmployeeById(employeeId);

        // 반환
        return ResponseEntity.ok(responseAuthorDTO);
    }

    //직원 추가 창 팝업
    @GetMapping("/popup")
    public String employeePopupPage() {
        return "employee/employee";
    }

    // 직원 수정 창 팝업
    @GetMapping("/employee/update/{employeeId}")
    public String showUpdatePopup(@PathVariable("employeeId") int employeeId, Model model) {
        System.out.println("수정 페이지 진입, ID = " + employeeId);
        model.addAttribute("employeeId", employeeId);
        return "employee/employee";
    }
}
