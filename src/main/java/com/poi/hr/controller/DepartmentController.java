package com.poi.hr.controller;

import com.poi.hr.domain.hr.DepPositionEmployee;
import com.poi.hr.dto.DepartmentDto;
import com.poi.hr.repository.DepPositionEmployeeRepository;
import com.poi.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@Validated
public class DepartmentController {

    private static final Logger logger = Logger.getLogger(DepartmentController.class.getName());
    private final DepartmentService departmentService;
    private final DepPositionEmployeeRepository depPositionEmployeeRepository;

    @Autowired
    public DepartmentController(DepartmentService departmentService,
                                DepPositionEmployeeRepository depPositionEmployeeRepository) {
        this.departmentService = departmentService;
        this.depPositionEmployeeRepository = depPositionEmployeeRepository;
    }

    @GetMapping("/departmentInfo")
    public String departmentInfo(Model model) {
        List<DepartmentDto> flatList = departmentService.getDepartmentList();
        List<DepartmentDto> deptTree = departmentService.buildDeptTree(flatList);
        model.addAttribute("deptTree", deptTree);
        return "department/departmentInfo";
    }

    @ResponseBody
    @GetMapping("/department/{deptId}/employees")
    public List<EmployeeResponse> getEmployeesByDepartment(@PathVariable Integer deptId) {
        List<DepPositionEmployee> dpeList = departmentService.getEmployeesByDeptId(deptId);

        return dpeList.stream()
                .map(dpe -> new EmployeeResponse(
                        dpe.getEmployee().getEmployeeName(),
                        dpe.getEmployee().getEmployeeNumber(),
                        dpe.getTeamPosition().getPositionName()
                ))
                .collect(Collectors.toList());
    }

    public record EmployeeResponse(String employeeName, String employeeNumber, String teamPositionName) {
    }
}


