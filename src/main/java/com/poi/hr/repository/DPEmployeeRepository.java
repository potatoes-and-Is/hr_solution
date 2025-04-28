package com.poi.hr.repository;

import com.poi.hr.domain.employee.DepPositionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DPEmployeeRepository extends JpaRepository<DepPositionEmployee, Integer> {
}
