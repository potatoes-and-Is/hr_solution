package com.poi.hr.domain.approval;

import com.poi.hr.domain.enums.LeaveType;
import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leave_reqs")
public class LeaveReq extends ApprovalDoc {

    @Column(name = "leave_start_date", nullable = false)
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date", nullable = false)
    private LocalDate leaveEndDate;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    public LeaveReq() {
    }

    public LeaveReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, LocalDate leaveStartDate, LocalDate leaveEndDate, LeaveType leaveType) {
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

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    @Override
    public String toString() {
        return "LeaveReq{" +
                "leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                ", leaveType=" + leaveType +
                '}';
    }
}
