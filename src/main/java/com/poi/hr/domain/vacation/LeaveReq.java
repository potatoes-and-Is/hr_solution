package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
//@Table(name = "Leave_reqs")
public class LeaveReq extends ApprovalDoc {

    @Column(name = "leave_start_date", nullable = false)
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date", nullable = false)
    private LocalDate leaveEndDate;

    @Column(name = "leave_type", nullable = false, length = 30)
    private String leaveType;

    public LeaveReq() {

    }

    public LeaveReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, LocalDate leaveStartDate, LocalDate leaveEndDate, String leaveType) {
        super(employee, docType, approvalTitle, approvalContent, approvalReason);
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.leaveType = leaveType;
    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Override
    public String toString() {
        return "LeaveReq{" +
                "leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                ", leaveType='" + leaveType + '\'' +
                '}';
    }
}
