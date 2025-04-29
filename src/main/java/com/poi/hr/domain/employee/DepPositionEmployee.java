package com.poi.hr.domain.employee;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.hr.TeamPosition;
import jakarta.persistence.*;

@Entity
@Table(name = "Dep_position_employees")
public class DepPositionEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpe_id")
    private Integer dpeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    public DepPositionEmployee() {
    }

    public DepPositionEmployee(Dept department, Employee employee, TeamPosition teamPosition) {
        this.dept = department;
        this.employee = employee;
        this.teamPosition = teamPosition;
    }

    public Integer getDpeId() {
        return dpeId;
    }

    public void setDpeId(Integer dpeId) {
        this.dpeId = dpeId;
    }

    public Dept getDepartment() {
        return dept;
    }

    public void setDepartment(Dept dept) {
        this.dept = dept;
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