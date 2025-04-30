package com.poi.hr.dto.approval;

import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;

public class ApprovalHistorySaveDto {

    private int approvalLineId;
    private ApprovalDocStatus approvalDocStatus;
    private String approvalComment;

    public ApprovalHistorySaveDto() {
    }

    public ApprovalHistorySaveDto(int approvalLineId, ApprovalDocStatus approvalStatus, String approvalContent) {
        this.approvalLineId = approvalLineId;
        this.approvalDocStatus = approvalStatus;
        this.approvalComment = approvalContent;
    }

    public int getApprovalLineId() {
        return approvalLineId;
    }

    public void setApprovalLineId(int approvalLineId) {
        this.approvalLineId = approvalLineId;
    }

    public ApprovalDocStatus getApprovalDocStatus() {
        return approvalDocStatus;
    }

    public void setApprovalDocStatus(ApprovalDocStatus approvalDocStatus) {
        this.approvalDocStatus = approvalDocStatus;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }
}
