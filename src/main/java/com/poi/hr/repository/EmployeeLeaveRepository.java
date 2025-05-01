package com.poi.hr.repository;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {
    Optional<EmployeeLeave> findByApprovalDoc_ApprovalDocId(int approvalDocId);
}
