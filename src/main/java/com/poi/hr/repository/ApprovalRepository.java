package com.poi.hr.repository;

import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Attend, Integer> {
}


