package com.poi.hr.dto.approval;

import java.time.LocalDate;

public class ApprovalEmpLeaveResponseDto extends ApprovalDetailDto {

    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveType;

    public ApprovalEmpLeaveResponseDto() {
    }

    public ApprovalEmpLeaveResponseDto(
            int approvalDocId,
            String docTypeCode,
            String docTypeName,
            String approvalTitle,
            LocalDate createdAt,
            LocalDate approvalDate,
            String approvalStatus,
            String approvalContent,
            String approvalReason,
            LocalDate leaveStartDate,
            LocalDate leaveEndDate,
            String leaveType
    ) {
        super(approvalDocId, docTypeCode, docTypeName, approvalTitle, createdAt, approvalDate, approvalStatus, approvalContent, approvalReason);
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.leaveType = leaveType;
    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}
