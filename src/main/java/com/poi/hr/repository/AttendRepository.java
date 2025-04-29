package com.poi.hr.repository;

import com.poi.hr.domain.attendance.Attend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Integer> {

    Optional<Attend> findByEmployeeEmployeeIdAndAttendDate(int employeeEmployeeId, LocalDate attendDate);
    List<Attend> findAllByEmployeeEmployeeId(int employeeEmployeeId);

}
