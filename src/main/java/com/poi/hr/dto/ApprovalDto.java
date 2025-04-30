package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalDto {

    private int approvalDocId;
    private String docTypeName;
    private String approvalTitle;
    private LocalDate createdAt;
    private LocalDate approvalDate;
    private String approvalStatus;
    private String approvalContent;
    private String approvalReason;

    public ApprovalDto() {
    }

    public ApprovalDto(int approvalDocId, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalContent, String approvalReason) {
        this.approvalDocId = approvalDocId;
        this.docTypeName = docTypeName;
        this.approvalTitle = approvalTitle;
        this.createdAt = createdAt;
        this.approvalDate = approvalDate;
        this.approvalStatus = approvalStatus;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public String getApprovalReason() {
        return approvalReason;
    }
}
