package com.poi.hr.dto.mapper;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.hr.Level;
import com.poi.hr.dto.EmployeeRequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDTO dto, Level level) {
        Employee employee = new Employee();
        employee.setEmployeeId(dto.getEmployeeId());
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setGender(dto.getGender());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
        employee.setPhone(dto.getPhone());
        employee.setEmployeeIdentity(dto.getEmployeeIdentity());
        employee.setEmployeeStatus(dto.getEmployeeStatus());
        employee.setHireDate(dto.getHireDate() != null ? dto.getHireDate() : LocalDate.now());
        employee.setRetireDate(dto.getRetireDate());
        employee.setEmployeeNumber(dto.getEmployeeNumber());
        employee.setLevel(level); // ✅ 여기만 변경
        return employee;
    }
}
