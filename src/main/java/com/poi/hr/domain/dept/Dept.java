package com.poi.hr.domain.dept;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Depts")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_code", nullable = false, length = 30)
    private String deptCode;

    @Column(name = "dept_name", nullable = false, length = 30)
    private String deptName;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 30)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    //상위 부서 (parent_dept_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dept_id")
    private Dept parentDept;

    //하위 부서 (양방향 관계 맺기 | self-join 시 필수)
    @OneToMany(mappedBy = "parentDept", fetch = FetchType.LAZY)
    private List<Dept> childDepts = new ArrayList<>();

    public Dept() {
    }

    public Dept(String deptCode, String deptName, String createdBy, String updatedBy, Dept parentDept) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.parentDept = parentDept;
    }

    public Dept(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
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

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Dept getParentDept() {
        return parentDept;
    }

    public void setParentDept(Dept parentDept) {
        this.parentDept = parentDept;
    }

    public List<Dept> getChildDepts() {
        return childDepts;
    }

    public void setChildDepts(List<Dept> childDepts) {
        this.childDepts = childDepts;
    }

    @Override
    public String toString() {
        return "Depts{" +
                "deptId=" + deptId +
                ", deptCode=" + deptCode +
                ", deptName='" + deptName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", parentDept=" + parentDept +
                '}';
    }
}