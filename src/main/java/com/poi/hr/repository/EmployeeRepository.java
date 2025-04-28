package com.poi.hr.repository;


import com.poi.hr.domain.login.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmployeeNumber(String employeeNumber);
}