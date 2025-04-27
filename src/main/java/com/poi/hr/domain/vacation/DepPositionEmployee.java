package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

@Entity
@Table(name = "Dep_Position_Employees")
public class DepPositionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private Integer dpeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public DepPositionEmployee() {

    }

    public DepPositionEmployee(TeamPosition teamPosition, Dept dept, Employee employee) {
        this.teamPosition = teamPosition;
        this.dept = dept;
        this.employee = employee;
    }

    public Integer getDpeId() {
        return dpeId;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }

    public Dept getDept() {
        return dept;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setTeamPosition(TeamPosition teamPosition) {
        this.teamPosition = teamPosition;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepPositionEmployee{" +
                "dpeId=" + dpeId +
                ", teamPosition=" + (teamPosition != null ? teamPosition.getTeamPositionId() : null) +
                ", dept=" + (dept != null ? dept.getDeptId() : null) +
                ", employee=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}
