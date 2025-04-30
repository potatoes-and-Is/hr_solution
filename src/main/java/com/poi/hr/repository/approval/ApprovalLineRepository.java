package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ApprovalLineRepository extends CrudRepository<ApprovalLine, Integer> {
    Optional<ApprovalLine> findByApprovalDocIdAndEmployeeId(int approvalDocId, int approverId);

    List<ApprovalLine> findByApprovalDocIdOrderByApprovalLineOrderAsc(int docId);
}
