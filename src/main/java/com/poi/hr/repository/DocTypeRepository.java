package com.poi.hr.repository;

import com.poi.hr.domain.approval.DocType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocTypeRepository extends JpaRepository<DocType, Integer> {
    DocType findByDocTypeCode(String docTypeCode);
}
