package com.poi.hr.dto.vacation;

import com.poi.hr.domain.vacation.VacationType;
import com.poi.hr.dto.approval.ApprovalLineSaveDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class VacationSaveDTO {

    private String docTypeCode;
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private VacationType vacationType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate vacReqStartDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate vacReqEndDate;
    private Double vacUseDays;
    private List<ApprovalLineSaveDto> approvalLineList;

    public VacationSaveDTO() {
    }

    public VacationSaveDTO(VacationType vacationType, Double vacUseDays, LocalDate vacReqStartDate, LocalDate vacReqEndDate, String approvalReason) {
        this.vacationType = vacationType;
        this.vacUseDays = vacUseDays;
        this.vacReqStartDate = vacReqStartDate;
        this.vacReqEndDate = vacReqEndDate;
        this.approvalReason = approvalReason;
    }

    public VacationSaveDTO(String docTypeCode, String approvalTitle, String approvalContent, String approvalReason, VacationType vacationType, LocalDate vacReqStartDate, LocalDate vacReqEndDate, Double vacUseDays, List<ApprovalLineSaveDto> approvalLineList) {
        this.docTypeCode = docTypeCode;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
        this.vacationType = vacationType;
        this.vacReqStartDate = vacReqStartDate;
        this.vacReqEndDate = vacReqEndDate;
        this.vacUseDays = vacUseDays;
        this.approvalLineList = approvalLineList;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public void setApprovalTitle(String approvalTitle) {
        this.approvalTitle = approvalTitle;
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

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
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

    public Double getVacUseDays() {
        return vacUseDays;
    }

    public void setVacUseDays(Double vacUseDays) {
        this.vacUseDays = vacUseDays;
    }

    public List<ApprovalLineSaveDto> getApprovalLineList() {
        return approvalLineList;
    }

    public void setApprovalLineList(List<ApprovalLineSaveDto> approvalLineList) {
        this.approvalLineList = approvalLineList;
    }
}
