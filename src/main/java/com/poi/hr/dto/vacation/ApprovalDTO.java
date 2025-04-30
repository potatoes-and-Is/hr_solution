package com.poi.hr.dto.vacation;

import java.time.LocalDate;

public class ApprovalDTO {

    private int approvalDocId;
    private String approvalTitle;
    private String employeeName;
    private String docTypeName;
    private String approvalDocStatus;
    private LocalDate createdAt;
    private LocalDate approvalDate;

    public ApprovalDTO() {
    }

    public ApprovalDTO(int approvalDocId, String approvalTitle, String employeeName,
                       String docTypeName, String approvalDocStatus,
                       LocalDate createdAt, LocalDate approvalDate) {
        this.approvalDocId = approvalDocId;
        this.approvalTitle = approvalTitle;
        this.employeeName = employeeName;
        this.docTypeName = docTypeName;
        this.approvalDocStatus = approvalDocStatus;
        this.createdAt = createdAt;
        this.approvalDate = approvalDate;
    }

    public int getApprovalDocId() {
        return approvalDocId;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDocTypeName() {
        return docTypeName;
    }

    public String getApprovalDocStatus() {
        return approvalDocStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDocId(int approvalDocId) {
        this.approvalDocId = approvalDocId;
    }

    public void setApprovalTitle(String approvalTitle) {
        this.approvalTitle = approvalTitle;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDocTypeName(String docTypeName) {
        this.docTypeName = docTypeName;
    }

    public void setApprovalDocStatus(String approvalDocStatus) {
        this.approvalDocStatus = approvalDocStatus;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }
}
