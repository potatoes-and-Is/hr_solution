package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApprovalLineRepository extends CrudRepository<ApprovalLine, Integer> {
    @Query("SELECT al FROM ApprovalLine al " +
            "WHERE al.approvalDoc.approvalDocId = :approvalDocId " +
            "AND al.employee.employeeId = :employeeId")
    Optional<ApprovalLine> findApprovalLine(
            @Param("approvalDocId") Long approvalDocId,
            @Param("employeeId") Long employeeId);

    @Query("SELECT al FROM ApprovalLine al " +
            "WHERE al.approvalDoc.approvalDocId = :approvalDocId " +
            "ORDER BY al.approvalLineOrder ASC")
    List<ApprovalLine> findAllByDocIdOrderByOrder(
            @Param("approvalDocId") Long approvalDocId);
}
