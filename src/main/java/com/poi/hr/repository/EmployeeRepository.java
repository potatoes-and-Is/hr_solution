package com.poi.hr.repository;

import com.poi.hr.domain.hr.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
