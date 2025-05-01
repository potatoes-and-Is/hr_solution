package com.poi.hr.dto.vacation;

import java.time.LocalDate;

public class VacationResponseDTO {

    private int vacTypeId;
    private double vacUseDay;
    private LocalDate vacReqStartDate;
    private LocalDate vacReqEndDate;
    private String approvalReason;

    public VacationResponseDTO() {
    }

    public VacationResponseDTO(int vacTypeId, double vacUseDay, LocalDate vacReqStartDate, LocalDate vacReqEndDate, String approvalReason) {
        this.vacTypeId = vacTypeId;
        this.vacUseDay = vacUseDay;
        this.vacReqStartDate = vacReqStartDate;
        this.vacReqEndDate = vacReqEndDate;
        this.approvalReason = approvalReason;
    }

    public int getVacTypeId() {
        return vacTypeId;
    }

    public void setVacTypeId(int vacTypeId) {
        this.vacTypeId = vacTypeId;
    }

    public double getVacUseDay() {
        return vacUseDay;
    }

    public void setVacUseDay(double vacUseDay) {
        this.vacUseDay = vacUseDay;
    }

    public LocalDate getVacReqStartDate() {
        return vacReqStartDate;
    }

    public void setVacReqStartDate(LocalDate vacReqStartDate) {
        this.vacReqStartDate = vacReqStartDate;
    }

    public LocalDate getVacReqEndDate() {
        return vacReqEndDate;
    }

    public void setVacReqEndDate(LocalDate vacReqEndDate) {
        this.vacReqEndDate = vacReqEndDate;
    }

    public String getApprovalReason() {
        return approvalReason;
    }

    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }
}
