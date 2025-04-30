package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.ApprovalDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalDocRepository extends JpaRepository<ApprovalDoc, Integer> {

    ApprovalDoc findByApprovalDocId(int approvalDocId);
}
