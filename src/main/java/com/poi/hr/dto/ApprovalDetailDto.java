package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalDetailDto {

    private int approvalDocId;
    private String docTypeName;
    private String approvalTitle;
    private LocalDate createdAt;
    private LocalDate approvalDate;
    private String approvalStatus;
    private String approvalReason;

    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private double vacUseDay;

    public ApprovalDetailDto() {
    }

    public ApprovalDetailDto(int approvalDocId, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalReason, LocalDate vacReqStart, LocalDate vacReqEnd, double vacUseDay) {
        this.approvalDocId = approvalDocId;
        this.docTypeName = docTypeName;
        this.approvalTitle = approvalTitle;
        this.createdAt = createdAt;
        this.approvalDate = approvalDate;
        this.approvalStatus = approvalStatus;
        this.approvalReason = approvalReason;
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.vacUseDay = vacUseDay;
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

    public String getApprovalReason() {
        return approvalReason;
    }

    public LocalDate getVacReqStart() {
        return vacReqStart;
    }

    public LocalDate getVacReqEnd() {
        return vacReqEnd;
    }

    public double getVacUseDay() {
        return vacUseDay;
    }
}
