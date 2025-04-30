package com.poi.hr.repository.approval;

import com.poi.hr.domain.vacation.ApprovalLine;
import org.springframework.data.repository.CrudRepository;

public interface ApprovalLineRepository extends CrudRepository<ApprovalLine, Integer> {
}
