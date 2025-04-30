package com.poi.hr.dto;

public class ApprovalEmpLeaveSaveDTO {
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private String vacReqStart;
    private String vacReqEnd;
    private String leaveType;
    private String approverList;

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

    public String getVacReqStart() {
        return vacReqStart;
    }

    public void setVacReqStart(String vacReqStart) {
        this.vacReqStart = vacReqStart;
    }

    public String getVacReqEnd() {
        return vacReqEnd;
    }

    public void setVacReqEnd(String vacReqEnd) {
        this.vacReqEnd = vacReqEnd;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getApproverList() {
        return approverList;
    }

    public void setApproverList(String approverList) {
        this.approverList = approverList;
    }

    public ApprovalEmpLeaveSaveDTO(String approvalTitle, String approvalContent, String approvalReason, String vacReqStart, String vacReqEnd, String leaveType, String approverList) {
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.leaveType = leaveType;
        this.approverList = approverList;
    }

    public ApprovalEmpLeaveSaveDTO() {

    }
}
