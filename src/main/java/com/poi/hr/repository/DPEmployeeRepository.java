package com.poi.hr.repository;

import com.poi.hr.domain.employee.DPEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DPEmployeeRepository extends JpaRepository<DPEmployee, Integer> {
}
