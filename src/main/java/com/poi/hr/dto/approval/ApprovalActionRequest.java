package com.poi.hr.dto.approval;

public class ApprovalActionRequest {

    private String approvalComment;
    private boolean approved;

    public ApprovalActionRequest(String approvalComment, boolean approved) {
        this.approvalComment = approvalComment;
        this.approved = approved;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
