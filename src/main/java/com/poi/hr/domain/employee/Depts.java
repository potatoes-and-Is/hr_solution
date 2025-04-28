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
    private String dept_code;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "parent_dept_id")
    private Integer parent_dept_id;

    public Depts() {

    }

    public Depts(int deptId, String dept_code, String dept_name, String created_by, LocalDateTime created_at, String updated_by, LocalDateTime updated_at, int parent_dept_id) {
        this.deptId = deptId;
        this.dept_code = dept_code;
        this.dept_name = dept_name;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_by = updated_by;
        this.updated_at = updated_at;
        this.parent_dept_id = parent_dept_id;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public int getParent_dept_id() {
        return parent_dept_id;
    }

    public void setParent_dept_id(int parent_dept_id) {
        this.parent_dept_id = parent_dept_id;
    }

    @Override
    public String toString() {
        return "Depts{" +
                "deptId=" + deptId +
                ", dept_code='" + dept_code + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                ", updated_by='" + updated_by + '\'' +
                ", updated_at=" + updated_at +
                ", parent_dept_id=" + parent_dept_id +
                '}';
    }
}
