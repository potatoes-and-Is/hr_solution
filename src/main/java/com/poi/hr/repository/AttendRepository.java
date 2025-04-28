package com.poi.hr.repository;

import com.poi.hr.domain.attendance.Attend;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Integer> {

    Optional<Attend> findByEmployeeEmployeeIdAndAttendDate(int employeeEmployeeId, LocalDate attendDate);

}
