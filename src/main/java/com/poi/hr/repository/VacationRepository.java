package com.poi.hr.repository;

import com.poi.hr.domain.vacation.VacationBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends JpaRepository<VacationBalance, Integer> {
    VacationBalance findByEmployee_EmployeeId(Integer employeeId);
}
