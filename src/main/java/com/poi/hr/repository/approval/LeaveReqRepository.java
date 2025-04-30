package com.poi.hr.repository.approval;

import com.poi.hr.domain.approval.LeaveReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveReqRepository extends JpaRepository<LeaveReq, Integer> {
}
