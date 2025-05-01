package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.LeaveReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveReqRepository extends JpaRepository<LeaveReq, Integer> {
    Optional<LeaveReq> findByApprovalDocId(int approvalDocId);
}
