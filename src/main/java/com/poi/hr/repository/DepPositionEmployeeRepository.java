package com.poi.hr.repository;

import com.poi.hr.domain.hr.DepPositionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepPositionEmployeeRepository extends JpaRepository<DepPositionEmployee, Integer> {

    @Query("SELECT dpe FROM DepPositionEmployee dpe " +
            "JOIN FETCH dpe.employee e " +
            "JOIN FETCH dpe.teamPosition tp " +
            "WHERE dpe.department.deptId = :deptId")
    List<DepPositionEmployee> findByDeptId(Integer deptId);
}

