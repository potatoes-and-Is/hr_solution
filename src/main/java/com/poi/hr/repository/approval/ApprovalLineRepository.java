package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import java.util.List;

public interface ApprovalLineRepository extends CrudRepository<ApprovalLine, Integer> {

    // 특정 문서의 결재라인을 결재 순서대로 가져오기
    List<ApprovalLine> findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(int approvalDocId);
    @Query("SELECT al FROM ApprovalLine al " +
            "WHERE al.approvalDoc.approvalDocId = :approvalDocId " +
            "AND al.employee.employeeId = :employeeId")
    Optional<ApprovalLine> findApprovalLine(
            @Param("approvalDocId") int approvalDocId,
            @Param("employeeId") int employeeId);

    @Query("SELECT al FROM ApprovalLine al " +
            "WHERE al.approvalDoc.approvalDocId = :approvalDocId " +
            "ORDER BY al.approvalLineOrder ASC")
    List<ApprovalLine> findAllByDocIdOrderByOrder(
            @Param("approvalDocId") int approvalDocId);

    @Query("""
    SELECT al.approvalDoc
    FROM ApprovalLine al
    WHERE al.employee.employeeId = :employeeId
      AND al.approvalStatus = 'PENDING'
      AND NOT EXISTS (
          SELECT ah FROM ApprovalHistory ah
          WHERE ah.approvalLine.approvalLineId = al.approvalLineId
      )
""")
    List<ApprovalDoc> findPendingDocsForMyApproval(@Param("employeeId") int employeeId);

    @Query("SELECT al FROM ApprovalLine al WHERE al.approvalDoc.approvalDocId = :approvalDocId ORDER BY al.approvalLineOrder ASC")
    List<ApprovalLine> findLinesByApprovalDocIdOrdered(@Param("approvalDocId") int approvalDocId);

}
