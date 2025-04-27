package com.poi.hr.domain.hr;

import com.poi.hr.domain.department.Department;
import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "dep_position_employees")
public class DepPositionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private Integer dpeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    public DepPositionEmployee() {
    }

    public DepPositionEmployee(Integer dpeId, Department department, Employee employee, TeamPosition teamPosition) {
        this.dpeId = dpeId;
        this.department = department;
        this.employee = employee;
        this.teamPosition = teamPosition;
    }

    public Integer getDpeId() {
        return dpeId;
    }

    public void setDpeId(Integer dpeId) {
        this.dpeId = dpeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(TeamPosition teamPosition) {
        this.teamPosition = teamPosition;
    }

}