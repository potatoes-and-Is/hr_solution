package com.poi.hr.controller;

import com.poi.hr.domain.employee.Depts;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.repository.DeptRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/depts")
@Validated
public class DeptController {

    private final DeptRepository deptRepository;

    public DeptController(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @GetMapping("/list")
    public List<DeptDTO> getAllDept() {
        return deptRepository.findAll().stream()
                .map(dept -> new DeptDTO(dept.getDeptId(), dept.getDept_name()))
                .toList();
    }
}
