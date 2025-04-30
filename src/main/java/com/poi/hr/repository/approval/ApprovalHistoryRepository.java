package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalHistoryRepository extends JpaRepository<ApprovalHistory, Integer> {
    // 기본 save(), findById() 등 모두 포함됨
}
