package com.poi.hr.dto.approval;

import com.poi.hr.domain.enums.LeaveType;

import java.time.LocalDate;
import java.util.List;

public class ApprovalEmpLeaveSaveDto {

    private String docType;
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private LeaveType leaveType;
    private List<ApprovalLineSaveDto> approvalLineList;

    public ApprovalEmpLeaveSaveDto() {
    }

    public ApprovalEmpLeaveSaveDto(String docType, String approvalTitle, String approvalContent, String approvalReason, LocalDate leaveStartDate, LocalDate leaveEndDate, LeaveType leaveType, List<ApprovalLineSaveDto> approvalLineList) {
        this.docType = docType;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.leaveType = leaveType;
        this.approvalLineList = approvalLineList;
    }

    public String getDocType() {
        return docType;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public String getApprovalReason() {
        return approvalReason;
    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public List<ApprovalLineSaveDto> getApprovalLineList() {
        return approvalLineList;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setApprovalTitle(String approvalTitle) {
        this.approvalTitle = approvalTitle;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent;
    }

    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public void setApprovalLineList(List<ApprovalLineSaveDto> approvalLineList) {
        this.approvalLineList = approvalLineList;
    }
}
