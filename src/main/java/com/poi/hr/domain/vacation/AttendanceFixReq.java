package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(
        name = "Attendance_fix_reqs",
        uniqueConstraints = {
                @UniqueConstraint(
                    name = "uq_attendance_fix_req_attend_id",
                    columnNames = {"attend_id"}
                )
        }
)
public class AttendanceFixReq extends ApprovalDoc {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attend_id")
    private Attend attend;

    @Column(name = "req_check_in_time")
    private LocalTime reqCheckInTime;

    @Column(name = "req_check_out_time")
    private LocalTime reqCheckOutTime;

    public AttendanceFixReq() {

    }

    public AttendanceFixReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, LocalTime reqCheckInTime, LocalTime reqCheckOutTime) {
        super(employee, docType, approvalTitle, approvalContent, approvalReason);
        this.reqCheckInTime = reqCheckInTime;
        this.reqCheckOutTime = reqCheckOutTime;
    }

    public Attend getAttend() {
        return attend;
    }

    public LocalTime getReqCheckInTime() {
        return reqCheckInTime;
    }

    public LocalTime getReqCheckOutTime() {
        return reqCheckOutTime;
    }

    public void setReqCheckInTime(LocalTime reqCheckInTime) {
        this.reqCheckInTime = reqCheckInTime;
    }

    public void setReqCheckOutTime(LocalTime reqCheckOutTime) {
        this.reqCheckOutTime = reqCheckOutTime;
    }

    @Override
    public String toString() {
        return "AttendanceFixReq{" +
                "attendId=" + (attend != null ? attend.getAttendId() : null) +
                ", reqCheckInTime=" + reqCheckInTime +
                ", reqCheckOutTime=" + reqCheckOutTime +
                '}';
    }
}