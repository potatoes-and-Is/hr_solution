package com.poi.hr.dto.approval;

import java.time.LocalDate;

public class ApprovalDetailDTO {

    private int approvalDocId;
    private String docTypeCode;
    private String docTypeName;
    private String approvalTitle;
    private LocalDate createdAt;
    private LocalDate approvalDate;
    private String approvalStatus;
    private String approvalContent;
    private String approvalReason;

    public ApprovalDetailDTO() {
    }

    public ApprovalDetailDTO(int approvalDocId, String docTypeCode, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalContent, String approvalReason) {
        this.approvalDocId = approvalDocId;
        this.docTypeCode = docTypeCode;
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

    public void setApprovalDocId(int approvalDocId) {
        this.approvalDocId = approvalDocId;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public void setApprovalTitle(String approvalTitle) {
        this.approvalTitle = approvalTitle;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent;
    }

    public String getApprovalReason() {
        return approvalReason;
    }

    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }
}
