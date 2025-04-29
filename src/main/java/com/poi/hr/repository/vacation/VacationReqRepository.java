package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.VacationReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationReqRepository extends JpaRepository<VacationReq, Integer> {

    @Query("SELECT r FROM VacationReq r WHERE r.employee.employeeId = :employeeId AND FUNCTION('YEAR', r.vacReqStartDate) = :year")
    List<VacationReq> findByEmployeeIdAndYear(@org.springframework.data.repository.query.Param("employeeId") Integer employeeId,
                                              @org.springframework.data.repository.query.Param("year") int year);
}
/* vacReqStart 기준으로 연도만 비교 */