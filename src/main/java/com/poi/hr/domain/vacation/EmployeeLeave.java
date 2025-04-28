package com.poi.hr.domain.vacation;

import com.poi.hr.domain.login.entity.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee_leaves")
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private int leaveId;

    @Column(name = "leave_reason", nullable = false, length = 255)
    private String leaveReason;

    @Column(name = "leave_start_date", nullable = false)
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date", nullable = false)
    private LocalDate leaveEndDate;

    @Column(name = "updated_by", length = 30)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public EmployeeLeave() {
    }

    public EmployeeLeave(String leaveReason, LocalDate leaveStartDate, LocalDate leaveEndDate, String updatedBy, Employee employee) {
        this.leaveReason = leaveReason;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.updatedBy = updatedBy;
        this.employee = employee;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeLeave{" +
                "leaveId=" + leaveId +
                ", leaveReason='" + leaveReason + '\'' +
                ", leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}