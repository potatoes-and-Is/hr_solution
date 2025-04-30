package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalLineRepository extends JpaRepository<ApprovalLine, Integer> {
}
