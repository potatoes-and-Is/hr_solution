package com.poi.hr.domain.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "Dep_Position_Employees")
public class DepPositionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private int dpeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Depts depts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public DepPositionEmployee() {}

    public DepPositionEmployee(TeamPosition teamPosition, Depts depts, Employee employee) {
        this.teamPosition = teamPosition;
        this.depts = depts;
        this.employee = employee;
    }

    public int getDpeId() {
        return dpeId;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }

    public Depts getDept() {
        return depts;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setTeamPosition(TeamPosition teamPosition) {
        this.teamPosition = teamPosition;
    }

    public void setDept(Depts dept) {
        this.depts = dept;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepPositionEmployee{" +
                "dpeId=" + dpeId +
                ", teamPosition=" + (teamPosition != null ? teamPosition.getTeamPositionId() : null) +
                ", dept=" + (depts != null ? depts.getDeptId() : null) +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}
