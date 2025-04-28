package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Careers")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private int careerId;

    @Column(name = "previous_company", nullable = false, length = 50)
    private String previousCompany;

    @Column(name = "previous_dept_name", nullable = false, length = 30)
    private String previousDeptName;

    @Column(name = "previous_level", nullable = false, length = 30)
    private String previousLevel;

    @Column(name = "retire_reason", nullable = false, length = 255)
    private String retireReason;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Career() {

    }

    public Career(String previousCompany, String previousDeptName, String previousLevel, String retireReason, String createdBy, Employee employee) {
        this.previousCompany = previousCompany;
        this.previousDeptName = previousDeptName;
        this.previousLevel = previousLevel;
        this.retireReason = retireReason;
        this.createdBy = createdBy;
        this.employee = employee;
    }

    public int getCareerId() {
        return careerId;
    }

    public String getPreviousCompany() {
        return previousCompany;
    }

    public String getPreviousDeptName() {
        return previousDeptName;
    }

    public String getPreviousLevel() {
        return previousLevel;
    }

    public String getRetireReason() {
        return retireReason;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setPreviousCompany(String previousCompany) {
        this.previousCompany = previousCompany;
    }

    public void setPreviousDeptName(String previousDeptName) {
        this.previousDeptName = previousDeptName;
    }

    public void setPreviousLevel(String previousLevel) {
        this.previousLevel = previousLevel;
    }

    public void setRetireReason(String retireReason) {
        this.retireReason = retireReason;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Career{" +
                "careerId=" + careerId +
                ", previousCompany='" + previousCompany + '\'' +
                ", previousDeptName='" + previousDeptName + '\'' +
                ", previousLevel='" + previousLevel + '\'' +
                ", retireReason='" + retireReason + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}
