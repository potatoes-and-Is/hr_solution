package com.poi.hr.dto;

import com.poi.hr.domain.enums.LeaveType;

import java.time.LocalDate;

public class ApprovalEmpLeaveResponseDto extends ApprovalDetailDto {

    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private String leaveType;

    public ApprovalEmpLeaveResponseDto() {
    }

    public ApprovalEmpLeaveResponseDto(int approvalDocId, String docTypeCode, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalContent, String approvalReason, LocalDate vacReqStart, LocalDate vacReqEnd, String leaveType) {
        super(approvalDocId, docTypeCode, docTypeName, approvalTitle, createdAt, approvalDate, approvalStatus, approvalContent, approvalReason);
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.leaveType = leaveType;
    }

    public LocalDate getVacReqStart() {
        return vacReqStart;
    }

    public void setVacReqStart(LocalDate vacReqStart) {
        this.vacReqStart = vacReqStart;
    }

    public LocalDate getVacReqEnd() {
        return vacReqEnd;
    }

    public void setVacReqEnd(LocalDate vacReqEnd) {
        this.vacReqEnd = vacReqEnd;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}
