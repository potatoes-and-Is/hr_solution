package com.poi.hr.dto.approval;

import java.time.LocalDate;

public class ApprovalVacationSaveDTO {

    private String docType;
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private int vacUseDay;
    private int vacTypeId;

    public ApprovalVacationSaveDTO() {}

    public String getDocType() { return docType; }
    public void setDocType(String docType) { this.docType = docType; }

    public String getApprovalTitle() { return approvalTitle; }
    public void setApprovalTitle(String approvalTitle) { this.approvalTitle = approvalTitle; }

    public String getApprovalContent() { return approvalContent; }
    public void setApprovalContent(String approvalContent) { this.approvalContent = approvalContent; }

    public String getApprovalReason() { return approvalReason; }
    public void setApprovalReason(String approvalReason) { this.approvalReason = approvalReason; }

    public LocalDate getVacReqStart() { return vacReqStart; }
    public void setVacReqStart(LocalDate vacReqStart) { this.vacReqStart = vacReqStart; }

    public LocalDate getVacReqEnd() { return vacReqEnd; }
    public void setVacReqEnd(LocalDate vacReqEnd) { this.vacReqEnd = vacReqEnd; }

    public int getVacUseDay() { return vacUseDay; }
    public void setVacUseDay(int vacUseDay) { this.vacUseDay = vacUseDay; }

    public int getVacTypeId() { return vacTypeId; }
    public void setVacTypeId(int vacTypeId) { this.vacTypeId = vacTypeId; }
}

