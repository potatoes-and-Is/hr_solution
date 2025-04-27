package com.poi.hr.service;

import com.poi.hr.domain.department.Department;
import com.poi.hr.dto.DepartmentDto;
import com.poi.hr.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private static final Logger logger = Logger.getLogger(DepartmentService.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentService.class);
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> getDepartmentList() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map(dept -> new DepartmentDto(
                        dept.getDeptId(),
                        dept.getDeptCode(),
                        dept.getDeptName(),
                        dept.getCreatedBy(),
                        dept.getUpdatedBy(),
                        dept.getParentDeptId() != null ? dept.getParentDeptId().getDeptId() : null
                ))
                .collect(Collectors.toList());
    }

    public List<DepartmentDto> buildDeptTree(List<DepartmentDto> flatList) {
        Map<Integer, DepartmentDto> map = new HashMap<>();
        List<DepartmentDto> roots = new ArrayList<>();

        for (DepartmentDto dto : flatList) {
            map.put(dto.getDeptId(), dto);
        }

        for (DepartmentDto dto : flatList) {
            if (dto.getParentDeptId() == null) {
                roots.add(dto);
            } else {
                DepartmentDto parent = map.get(dto.getParentDeptId());
                if (parent != null) {
                    parent.getChildren().add(dto);
                }
            }
        }

        return roots;
    }


}

