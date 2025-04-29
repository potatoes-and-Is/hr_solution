package com.poi.hr.dto.mapper;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDTO dto) {
        Employee employee = new Employee(
                dto.getEmployeeId(),
                dto.getEmployeeNumber(),
                dto.getPositionName(),
                dto.getGender(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getPhone(),
                dto.getEmployeeIdentity(),
                dto.getStatus(),
                dto.getHireDate(),
                dto.getRetireDate(),
                dto.getLevel()
        );
        return employee;
    }
}
