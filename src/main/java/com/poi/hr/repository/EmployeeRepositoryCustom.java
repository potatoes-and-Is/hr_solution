package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> findAllEmployeesWithDetails();
}
