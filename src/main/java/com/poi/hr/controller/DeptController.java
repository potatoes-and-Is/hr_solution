package com.poi.hr.controller;

import com.poi.hr.dto.ResponseDeptDTO;
import com.poi.hr.repository.DeptsRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/depts")
@Validated
public class DeptController {

    private final DeptsRepository deptsRepository;

    public DeptController(DeptsRepository deptsRepository) {
        this.deptsRepository = deptsRepository;
    }

    @GetMapping("/list")
    public List<ResponseDeptDTO> getAllDept() {
        return deptsRepository.findAll().stream()
                .map(dept -> new ResponseDeptDTO(dept.getDeptId(), dept.getDeptName()))
                .toList();
    }
}
