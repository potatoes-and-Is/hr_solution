package com.poi.hr.repository;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.dto.ResponseAuthorDTO;
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
    LEFT JOIN DepPositionEmployee dep ON e.employeeId = dep.employee.employeeId
    LEFT JOIN dep.depts d
    LEFT JOIN dep.teamPosition tp
    LEFT JOIN e.level l
    WHERE e.employeeId = :employeeId
""")
    EmployeeRequestDTO getEmployeeDetail(int employeeId);


    @Query("SELECT COALESCE(MAX(e.employeeId), 0) + 1 FROM Employee e")
    int findNextEmployeeNumber();
}
