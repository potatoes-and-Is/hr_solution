package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.VacationBalance;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<VacationBalance, Integer> {
    VacationBalance findByEmployee_EmployeeId(Integer employeeId);
}
