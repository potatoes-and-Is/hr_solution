package com.poi.hr.repository;

import com.poi.hr.domain.approval.ApprovalDocs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<ApprovalDocs, Integer> {
}
