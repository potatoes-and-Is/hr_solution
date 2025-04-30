package com.poi.hr.domain.approval;

import com.poi.hr.domain.enums.LeaveType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leave_reqs")
public class LeaveReq extends ApprovalDocs {

    @Column(name = "leave_start_date")
    private LocalDate leaveStartDate;

    @Column(name = "leave_end_date")
    private LocalDate leaveEndDate;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    public LeaveReq() {
    }

    public LeaveReq(LocalDate leaveStartDate, LocalDate leaveEndDate, LeaveType leaveType) {
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
}
