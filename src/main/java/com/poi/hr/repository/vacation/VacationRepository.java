package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.VacationBalance;
import com.poi.hr.domain.vacation.VacationType;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<VacationBalance, Integer> {
    VacationBalance findByEmployee_EmployeeIdAndYear(Integer employeeId, int year);

    @Query("SELECT DISTINCT v.year FROM VacationBalance v WHERE v.employee.employeeId = :employeeId ORDER BY v.year DESC")
    List<Integer> findAvailableYearsByEmployeeId(@Param("employeeId") Integer employeeId);

//    VacationBalance findByEmployee_EmployeeIdAndVacationType_VacTypeIdAndYear(Integer employeeId, Integer vacTypeId, int year);

    @Query("SELECT v FROM VacationBalance v WHERE v.employee.employeeId = :employeeId AND v.vacationType.vacTypeId = :vacTypeId AND v.year :year")
    VacationBalance findVacationBalance(@Param("employeeId") Integer employeeId, @Param("vacTypeId") Integer vacTypeId, @Param("year") int year);
}