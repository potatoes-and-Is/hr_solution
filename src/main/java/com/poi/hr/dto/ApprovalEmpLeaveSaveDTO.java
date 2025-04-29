package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalEmpLeaveSaveDTO {

    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private String leaveType;
    private String approverList; // 콤마(,)로 구분된 결재자 리스트

    // 기본 생성자
    public ApprovalEmpLeaveSaveDTO() {}

    // Getter, Setter
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

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public String getApproverList() { return approverList; }
    public void setApproverList(String approverList) { this.approverList = approverList; }
}
