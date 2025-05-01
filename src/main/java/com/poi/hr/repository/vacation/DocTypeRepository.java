package com.poi.hr.repository.vacation;

import com.poi.hr.domain.vacation.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocTypeRepository extends JpaRepository<DocType, Integer> {
    Optional<DocType> findByDocTypeName(String docTypeName);
}
