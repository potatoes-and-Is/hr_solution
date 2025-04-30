package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApprovalLineRepository extends CrudRepository<ApprovalLine, Integer> {

    // 특정 문서의 결재라인을 결재 순서대로 가져오기
    List<ApprovalLine> findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(int approvalDocId);
}
