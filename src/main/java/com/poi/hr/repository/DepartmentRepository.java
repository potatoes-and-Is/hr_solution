package com.poi.hr.repository;

import com.poi.hr.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    Optional<Department> findByDeptName(String deptName);
    Optional<Department> findByDeptCode(String deptCode);

    void deleteByDeptName(String deptCode);
    List<Department> findByParentDeptIdIsNull();
    List<Department> findByParentDeptId(Department parentDept);
}
