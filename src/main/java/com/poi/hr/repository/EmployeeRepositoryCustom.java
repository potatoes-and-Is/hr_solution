package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<EmployeeRequestDTO> findAllEmployeesWithDetails();
}
