package com.poi.hr.repository.approval;

import com.poi.hr.domain.approval.ApprovalDoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<ApprovalDoc, Integer> {
}
