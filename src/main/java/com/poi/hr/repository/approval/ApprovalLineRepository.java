package com.poi.hr.repository.approval;

import com.poi.hr.domain.approval.ApprovalLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovalLineRepository extends JpaRepository<ApprovalLine, Integer> {

    // 문서 ID로 결재라인 리스트를 가져오되, 결재 순서로 정렬해서 가져온다
    List<ApprovalLine> findByApprovalDocId(int approvalDocId);
    List<ApprovalLine> findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(int approvalDocId);
}
