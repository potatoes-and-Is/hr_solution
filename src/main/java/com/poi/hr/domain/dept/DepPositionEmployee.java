package com.poi.hr.domain.dept;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.hr.TeamPosition;
import jakarta.persistence.*;

@Entity
@Table(name = "dep_position_employees")
public class DepPositionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private Integer dpeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    public DepPositionEmployee() {
    }

    public DepPositionEmployee(Dept dept, Employee employee, TeamPosition teamPosition) {
        this.employee = employee;
        this.dept = dept;
        this.teamPosition = teamPosition;
    }

    public int getDpeId() {
        return dpeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Dept getDept() {
        return dept;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }

    public void setDpeId(Integer dpeId) {
        this.dpeId = dpeId;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setTeamPosition(TeamPosition teamPosition) {
        this.teamPosition = teamPosition;
    }

    @Override
    public String toString() {
        return "DepPositionEmployee{" +
                "dpeId=" + dpeId +
                ", employee=" + employee +
                ", dept=" + dept +
                ", teamPosition=" + teamPosition +
                '}';
    }
}