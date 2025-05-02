package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalExecutionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalExecutionHistoryRepository extends JpaRepository<ApprovalExecutionHistory, Integer> {

}
