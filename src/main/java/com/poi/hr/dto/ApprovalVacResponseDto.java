package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalVacDto extends ApprovalDto {

    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private double vacUseDay;

    public ApprovalVacDto() {
    }

    public ApprovalVacDto(int approvalDocId, String docTypeName, String approvalTitle, LocalDate createdAt, LocalDate approvalDate, String approvalStatus, String approvalContent, String approvalReason, LocalDate vacReqStart, LocalDate vacReqEnd, double vacUseDay) {
        super(approvalDocId, docTypeName, approvalTitle, createdAt, approvalDate, approvalStatus, approvalContent, approvalReason);
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.vacUseDay = vacUseDay;
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
