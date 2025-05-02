package com.poi.hr.repository;

import com.poi.hr.domain.dept.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptAPIRepository extends JpaRepository<Dept, Integer> {
}
