package com.poi.hr.domain.login.entity;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class DepPositionEmployeeId implements Serializable {
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "team_position_id")
    private int teamPositionId;

    public DepPositionEmployeeId() {
    }

    public DepPositionEmployeeId(int employeeId, int deptId, int positionId) {
        this.employeeId = employeeId;
        this.deptId = deptId;
        this.teamPositionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DepPositionEmployeeId that = (DepPositionEmployeeId) o;
        return employeeId == that.employeeId && deptId == that.deptId && teamPositionId == that.teamPositionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, deptId, teamPositionId);
    }
}
