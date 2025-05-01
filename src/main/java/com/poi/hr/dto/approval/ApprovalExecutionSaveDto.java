package com.poi.hr.dto.approval;

public class ApprovalExecutionSaveDto {
    private String executionType;
    private String executionStatus;
    private String executedBy;
    private String comment;
    private int approvalDocId;

    public ApprovalExecutionSaveDto() {
    }

    public ApprovalExecutionSaveDto(String executionType, String executionStatus, String executedBy, String comment, int approvalDocId) {
        this.executionType = executionType;
        this.executionStatus = executionStatus;
        this.executedBy = executedBy;
        this.comment = comment;
        this.approvalDocId = approvalDocId;
    }

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getExecutedBy() {
        return executedBy;
    }

    public void setExecutedBy(String executedBy) {
        this.executedBy = executedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getApprovalDocId() {
        return approvalDocId;
    }

    public void setApprovalDocId(int approvalDocId) {
        this.approvalDocId = approvalDocId;
    }
}
