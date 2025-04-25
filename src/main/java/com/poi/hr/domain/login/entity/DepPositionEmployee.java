package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dep_position_employees")
public class DepPositionEmployee {

    @EmbeddedId
    private DepPositionEmployeeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("deptId")
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teamPositionId")
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    public DepPositionEmployee() {
    }

    public DepPositionEmployee(DepPositionEmployeeId id, Employee employee, Dept dept, TeamPosition teamPosition) {
        this.id = id;
        this.employee = employee;
        this.dept = dept;
        this.teamPosition = teamPosition;
    }

    public DepPositionEmployeeId getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Dept getDept() {
        return dept;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }
}
