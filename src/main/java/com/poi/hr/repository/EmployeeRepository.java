package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
    // 기본 메서드 + 커스텀 메서드 포함

    @Query("""
            SELECT new com.poi.hr.dto.EmployeeRequestDTO(
                e.employeeId, e.employeeNumber, e.employeeName, e.gender, e.address, e.email, e.password,
                e.phone, e.employeeIdentity, e.employeeStatus, e.hireDate, e.retireDate,
                d.deptId, tp.positionId, d.deptName, tp.positionName, l.levelId, l.levelName
                )
                FROM Employee e
                LEFT JOIN FETCH DepPositionEmployee dep ON e.employeeId = dep.dpeId
                LEFT JOIN FETCH Depts d ON dep.dpeId = d.deptId
                LEFT JOIN FETCH TeamPosition tp ON dep.teamPosition.positionId = tp.positionId
                LEFT JOIN FETCH Level l ON e.level.levelId = l.levelId
                WHERE e.employeeId = :employeeId
    """
    )
    EmployeeRequestDTO getEmployeeDetail(int employeeId);



}
