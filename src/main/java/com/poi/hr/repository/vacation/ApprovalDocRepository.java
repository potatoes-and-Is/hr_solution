package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalDocRepository extends JpaRepository<ApprovalDoc, Integer> {

    ApprovalDoc findByApprovalDocId(int approvalDocId);

    // 결재 상태로 문서 검색
    List<ApprovalDoc> findByApprovalStatus(ApprovalDocStatus status);

    // 특정 사원이 작성한 문서들 조회
    List<ApprovalDoc> findByEmployee_EmployeeId(int employeeId);
}
