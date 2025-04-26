package com.poi.hr.repository;

import com.poi.hr.domain.approval.VacationReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationReqRepository extends JpaRepository<VacationReq, Integer> {
}
