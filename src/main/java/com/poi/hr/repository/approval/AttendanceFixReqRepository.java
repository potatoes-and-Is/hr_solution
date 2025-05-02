package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.AttendanceFixReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceFixReqRepository extends JpaRepository<AttendanceFixReq, Integer> {
}
