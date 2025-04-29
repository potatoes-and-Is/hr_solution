package com.poi.hr.repository;

import com.poi.hr.domain.dept.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {

    Optional<Dept> findByDeptName(String deptName);
    Optional<Dept> findByDeptCode(String deptCode);

    Optional<Dept> findByDeptId(int deptId);
}
