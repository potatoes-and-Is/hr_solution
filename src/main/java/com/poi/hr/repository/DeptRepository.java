package com.poi.hr.repository;

import com.poi.hr.domain.employee.Depts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptsRepository extends JpaRepository<Depts, Integer> {
}
