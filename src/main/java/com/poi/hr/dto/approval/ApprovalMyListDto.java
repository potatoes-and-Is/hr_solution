package com.poi.hr.dto.approval;

import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;

import java.time.LocalDate;

public class ApprovalMyListDto {

    private int approvalDocId;
    private String docTypeName;
    private String approvalTitle;
    private String employeeName;
    private LocalDate createdAt;
    private ApprovalDocStatus approvalStatus;

    public ApprovalMyListDto() {
    }

    public ApprovalMyListDto(int approvalDocId, String docTypeName, String approvalTitle, String employeeName, LocalDate createdAt, ApprovalDocStatus approvalStatus) {
        this.approvalDocId = approvalDocId;
        this.docTypeName = docTypeName;
        this.approvalTitle = approvalTitle;
        this.employeeName = employeeName;
        this.createdAt = createdAt;
        this.approvalStatus = approvalStatus;
    }

    public int getApprovalDocId() {
        return approvalDocId;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public ApprovalDocStatus getApprovalStatus() {
        return approvalStatus;
    }
}

