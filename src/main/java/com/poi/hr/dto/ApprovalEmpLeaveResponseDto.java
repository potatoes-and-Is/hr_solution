package com.poi.hr.dto;

import com.poi.hr.domain.approval.DocType;
import com.poi.hr.domain.enums.ApprovalDocStatus;
import com.poi.hr.domain.enums.LeaveType;

import java.time.LocalDate;

public class ApprovalEmpLeaveDto extends ApprovalDetailDto {

    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private LeaveType leaveType;

    public ApprovalEmpLeaveDto() {
    }

    public ApprovalEmpLeaveDto(int approvalDocId, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalContent, String approvalReason, LocalDate vacReqStart, LocalDate vacReqEnd, LeaveType leaveType) {
        super(approvalDocId, docTypeName, approvalTitle, createdAt, approvalDate, approvalStatus, approvalContent, approvalReason);
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.leaveType = leaveType;
    }

    public LocalDate getVacReqStart() {
        return vacReqStart;
    }

    public LocalDate getVacReqEnd() {
        return vacReqEnd;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }
}
