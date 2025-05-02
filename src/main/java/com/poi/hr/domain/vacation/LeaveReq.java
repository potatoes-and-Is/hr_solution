package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.enums.LeaveType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Leave_reqs")
public class LeaveReq extends ApprovalDoc {

    @Column(name = "leave_start_date", nullable = false)
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date", nullable = false)
    private LocalDate leaveEndDate;

    @Column(name = "leave_type", nullable = false, length = 30)
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


    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }
}
