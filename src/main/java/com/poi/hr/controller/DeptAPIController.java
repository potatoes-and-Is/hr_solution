package com.poi.hr.controller;

import com.poi.hr.dto.ResponseDeptDTO;
import com.poi.hr.repository.DeptAPIRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/depts")
@Validated
public class DeptAPIController {

    private final DeptAPIRepository deptAPIRepository;

    public DeptAPIController(DeptAPIRepository deptAPIRepository) {
        this.deptAPIRepository = deptAPIRepository;
    }

    @GetMapping("/list")
    public List<ResponseDeptDTO> getAllDept() {
        return deptAPIRepository.findAll().stream()
                .map(dept -> new ResponseDeptDTO(dept.getDeptId(), dept.getDeptName()))
                .toList();
    }
}
