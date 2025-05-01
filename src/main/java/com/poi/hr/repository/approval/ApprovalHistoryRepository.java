package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalHistoryRepository extends JpaRepository<ApprovalHistory, Integer> {

}
