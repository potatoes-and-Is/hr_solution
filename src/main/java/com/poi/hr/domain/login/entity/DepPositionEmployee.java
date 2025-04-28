package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dep_position_employees")
public class DepPositionEmployee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private int dpeId;

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

    public DepPositionEmployee( Employee employee, Dept dept, TeamPosition teamPosition) {
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

    public TeamPosition getTeamPosition() {
        return teamPosition;
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
