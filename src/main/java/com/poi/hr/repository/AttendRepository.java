package com.poi.hr.repository;

import com.poi.hr.domain.attendance.Attend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendRepository extends JpaRepository<Attend, String> {


}
