package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.VacationGrantHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VacationGrantHistoryRepository extends JpaRepository<VacationGrantHistory, Integer> {

    @Query("SELECT v FROM VacationGrantHistory v WHERE v.employee.employeeId = :employeeId AND FUNCTION('YEAR', v.grantDate) = :year")
    List<VacationGrantHistory> findByEmployeeIdAndYear(@Param("employeeId") Integer employeeId, @Param("year") int year);
}
/*
grantDate에서 연도만 비교해야 해서 FUNCTION('YEAR', .grantDate) 사용
 */