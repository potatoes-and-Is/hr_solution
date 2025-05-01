package com.poi.hr.repository;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.dto.DeptDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    Optional<Dept> findByDeptName(String deptName);
    Optional<Dept> findByDeptCode(String deptCode);
    List<Dept> findByParentDept_DeptId(Integer deptId);
    Optional<Dept> findByDeptId(int deptId);

    List<Dept> findAll();
}
