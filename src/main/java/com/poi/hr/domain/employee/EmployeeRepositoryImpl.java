package com.poi.hr.domain.employee;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.repository.EmployeeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmployeeRequestDTO> findAllEmployeesWithDetails() {
        String sql = "SELECT " +
                "e.employee_id, e.employee_number, e.employee_name, e.gender, e.address, e.email, e.password, " +
                "e.phone, e.employee_identity, e.employee_status, e.hire_date, e.retire_date, " +
                "d.dept_id, d.dept_name, tp.team_position_id, tp.position_name, l.level_id, l.level_name " +
                "FROM employees e " +
                "JOIN Dep_Position_Employees dep ON e.employee_id = dep.employee_id " +
                "JOIN Depts d ON dep.dept_id = d.dept_id " +
                "JOIN Team_positions tp ON dep.team_position_id = tp.team_position_id " +
                "JOIN Levels l ON e.level_id = l.level_id";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<EmployeeRequestDTO> employees = new ArrayList<>();

        for (Object[] row : results) {
            EmployeeRequestDTO emp = new EmployeeRequestDTO();
            emp.setEmployeeId(((Number) row[0]).intValue());
            emp.setEmployeeNumber((String) row[1]);
            emp.setEmployeeName((String) row[2]);
            emp.setGender((String) row[3]);
            emp.setAddress((String) row[4]);
            emp.setEmail((String) row[5]);
            emp.setPassword((String) row[6]);
            emp.setPhone((String) row[7]);
            emp.setEmployeeIdentity((String) row[8]);
            emp.setEmployeeStatus((String) row[9]);
            emp.setHireDate(row[10] != null ? ((java.sql.Date) row[10]).toLocalDate() : null);
            emp.setRetireDate(row[11] != null ? ((java.sql.Date) row[11]).toLocalDate() : null);
            emp.setDeptId(row[12] != null ? ((Number) row[12]).intValue() : null);
            emp.setDeptName((String) row[13]);
            emp.setPositionId(row[14] != null ? ((Number) row[14]).intValue() : null);
            emp.setPositionName((String) row[15]);
            emp.setLevelId(row[16] != null ? ((Number) row[16]).intValue() : null);
            emp.setLevelName((String) row[17]);

            employees.add(emp);
        }

        return employees;
    }

}
