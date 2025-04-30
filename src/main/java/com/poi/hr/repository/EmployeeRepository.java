package com.poi.hr.repository;


import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {
    Optional<Employee> findByEmployeeNumber(String employeeNumber);

    @Query("""
    SELECT new com.poi.hr.dto.EmployeeRequestDTO(
        e.employeeId, e.employeeNumber, e.employeeName, e.gender, e.address, e.email, e.password,
        e.phone, e.employeeIdentity, e.employeeStatus, e.hireDate, e.retireDate,
        d.deptId, tp.teamPositionId, d.deptName, tp.positionName, l.levelId, l.levelName
    )
    FROM Employee e
    LEFT JOIN DepPositionEmployee dep ON e.employeeId = dep.employee.employeeId
    LEFT JOIN dep.dept d
    LEFT JOIN dep.teamPosition tp
    LEFT JOIN e.level l
    WHERE e.employeeId = :employeeId
""")
    EmployeeRequestDTO getEmployeeDetail(int employeeId);


    @Query("SELECT COALESCE(MAX(e.employeeId), 0) + 1 FROM Employee e")
    int findNextEmployeeNumber();

    @Query("""
    SELECT new com.poi.hr.dto.EmployeeRequestDTO(
        e.employeeId, e.employeeNumber, e.employeeName, e.gender, e.address, e.email, e.password,
        e.phone, e.employeeIdentity, e.employeeStatus, e.hireDate, e.retireDate,
        d.deptId, tp.teamPositionId, d.deptName, tp.positionName, l.levelId, l.levelName
    )
    FROM Employee e
    LEFT JOIN DepPositionEmployee dep ON e.employeeId = dep.employee.employeeId
    LEFT JOIN dep.dept d
    LEFT JOIN dep.teamPosition tp
    LEFT JOIN e.level l
    WHERE d.deptCode = :department
    """)
    List<EmployeeRequestDTO> getEmployeesByDepartment(String department);
}