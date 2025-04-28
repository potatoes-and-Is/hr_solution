package com.poi.hr.repository;

import com.poi.hr.domain.attendance.Attend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendRepository extends JpaRepository<Attend, String> {

    // 특정직원Id 와 날짜를 기준으로 출근 기록 조회. 출/퇴근 버튼 클릭 시 이 메서드로 해당 날짜 기록을 찾음
    Optional<Attend> findByEmployeeIdAndAttendDate(int employeeId, LocalDate attendDate);

}
