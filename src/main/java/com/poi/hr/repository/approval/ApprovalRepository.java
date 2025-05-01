package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprovalRepository extends JpaRepository<ApprovalDoc, Integer> {
}
