package com.poi.hr.domain.hr;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "depts")
public class Dept {

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
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_dept_id", referencedColumnName = "dept_id")
    private Dept parentDept;

    // 하위 부서 리스트 (OneToMany 관계)
    @OneToMany(mappedBy = "parentDeptId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dept> childDept;

    public Dept() {
    }

    public Dept(String deptCode, String deptName, String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt, Dept parentDeptId, List<Dept> childDept) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.parentDeptId = parentDeptId;
        this.childDept = childDept;
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

    public List<Dept> getChildDept() {
        return childDept;
    }

    public void setChildDept(List<Dept> childDept) {
        this.childDept = childDept;
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
                ", parentDeptId=" + parentDeptId +
                ", childDept=" + childDept +
                '}';
    }
}