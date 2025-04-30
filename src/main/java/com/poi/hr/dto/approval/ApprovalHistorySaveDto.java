package com.poi.hr.dto.approval;

import com.poi.hr.domain.approval.ApprovalLine;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;

public class ApprovalHistorySaveDto {

    private String comment;
    private ApprovalDocStatus approvalDocStatus;
    private int approvalLineId;

    public ApprovalHistorySaveDto() {
    }

    public ApprovalHistorySaveDto(String comment, ApprovalDocStatus approvalDocStatus, int approvalLineId) {
        this.comment = comment;
        this.approvalDocStatus = approvalDocStatus;
        this.approvalLineId = approvalLineId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ApprovalDocStatus getApprovalDocStatus() {
        return approvalDocStatus;
    }

    public void setApprovalDocStatus(ApprovalDocStatus approvalDocStatus) {
        this.approvalDocStatus = approvalDocStatus;
    }

    public int getApprovalLineId() {
        return approvalLineId;
    }

    public void setApprovalLineId(int approvalLineId) {
        this.approvalLineId = approvalLineId;
    }
}
