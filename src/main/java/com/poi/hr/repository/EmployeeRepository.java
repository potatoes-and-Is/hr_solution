package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
    // 기본 메서드 + 커스텀 메서드 포함
}
