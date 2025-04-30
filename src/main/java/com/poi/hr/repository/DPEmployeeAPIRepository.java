package com.poi.hr.repository;

import com.poi.hr.domain.employee.DepPositionEmployee;
import com.poi.hr.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DPEmployeeAPIRepository extends JpaRepository<DepPositionEmployee, Integer> {
    Optional<DepPositionEmployee> findByEmployee(Employee employee);
}
