package com.poi.hr.dto.approval;

import com.poi.hr.domain.enums.ApprovalDocStatus;

import java.time.LocalDate;

public class ApprovalListDto {

    private int approvalDocId;
    private String docTypeName;
    private String approvalTitle;
    private LocalDate createdAt;
    private LocalDate approvalDate;
    private ApprovalDocStatus approvalStatus;

    public ApprovalListDto() {
    }

    public ApprovalListDto(int approvalDocsId, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approval_date, ApprovalDocStatus approvalStatus) {
        this.approvalDocId = approvalDocsId;
        this.docTypeName = docTypeName;
        this.approvalTitle = approvalTitle;
        this.createdAt = createdAt;
        this.approvalDate = approval_date;
        this.approvalStatus = approvalStatus;
    }

    public int getApprovalDocsId() {
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

    public ApprovalDocStatus getApprovalStatus() {
        return approvalStatus;
    }
}
