package com.poi.hr.domain.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "Dep_Position_Employees")
public class DPEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "dept_id", nullable = false)
    private Integer deptId;

    @Column(name = "team_position_id", nullable = false)
    private Integer positionId;

    public DPEmployee() {}

    public DPEmployee(Integer employeeId, Integer deptId, Integer positionId) {
        this.employeeId = employeeId;
        this.deptId = deptId;
        this.positionId = positionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}
