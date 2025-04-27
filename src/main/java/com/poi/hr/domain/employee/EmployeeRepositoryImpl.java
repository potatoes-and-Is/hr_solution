package com.poi.hr.domain.employee;

import com.poi.hr.domain.employee.Employee;
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
    public List<Employee> findAllEmployeesWithDetails() {
        String sql = "SELECT " +
                "e.employee_id, e.employee_number, e.employee_name, e.gender, e.address, e.email, e.password, " +
                "e.phone, e.employee_identity, e.employee_status, e.hire_date, e.retire_date, " +
                "d.dept_name, tp.position_name, l.level_name " +
                "FROM employees e " +
                "JOIN Dep_Position_Employees dep ON e.employee_id = dep.employee_id " +
                "JOIN Depts d ON dep.dept_id = d.dept_id " +
                "JOIN Team_positions tp ON dep.team_position_id = tp.team_position_id " +
                "JOIN Levels l ON e.level_id = l.level_id";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();
        List<Employee> employees = new ArrayList<>();

        for (Object[] row : results) {
            Employee emp = new Employee();
            emp.setEmployeeId(((Number) row[0]).intValue());
            emp.setEmpNumber((String) row[1]);
            emp.setName((String) row[2]);
            emp.setGender((String) row[3]);
            emp.setAddress((String) row[4]);
            emp.setEmail((String) row[5]);
            emp.setPassword((String) row[6]);
            emp.setPhone((String) row[7]);
            emp.setIdentity((String) row[8]);
            emp.setStatus((String) row[9]);

            emp.setHireDate(row[10] != null ? ((java.sql.Date) row[10]).toLocalDate() : null);
            emp.setRetireDate(row[11] != null ? ((java.sql.Date) row[11]).toLocalDate() : null);

            emp.setDeptName((String) row[12]);
            emp.setPositionName((String) row[13]);
            emp.setLevelName((String) row[14]);

            employees.add(emp);
        }

        return employees;
    }
}
