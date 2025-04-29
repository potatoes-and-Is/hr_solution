package com.poi.hr.domain.employee;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "depts")
public class Depts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_code")
    private String deptCode;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "parent_dept_id")
    private Integer parentDeptId;

    public Depts() {

    }

    public Depts(int deptId, String deptCode, String deptName, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt, Integer parentDeptId) {
        this.deptId = deptId;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.parentDeptId = parentDeptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String dept_code) {
        this.deptCode = dept_code;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String dept_name) {
        this.deptName = dept_name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String created_by) {
        this.createdBy = created_by;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updated_by) {
        this.updatedBy = updated_by;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updatedAt = updated_at;
    }

    public int getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(int parent_dept_id) {
        this.parentDeptId = parent_dept_id;
    }

    @Override
    public String toString() {
        return "Depts{" +
                "deptId=" + deptId +
                ", dept_code='" + deptCode + '\'' +
                ", dept_name='" + deptName + '\'' +
                ", created_by='" + createdBy + '\'' +
                ", created_at=" + createdAt +
                ", updated_by='" + updatedBy + '\'' +
                ", updated_at=" + updatedAt +
                ", parent_dept_id=" + parentDeptId +
                '}';
    }
}
