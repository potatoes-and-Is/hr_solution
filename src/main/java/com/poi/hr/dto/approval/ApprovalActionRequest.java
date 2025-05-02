package com.poi.hr.dto.approval;

public class ApprovalActionRequest {

    private boolean approved;

    private String approvalComment;
    private String approvalRole;

    public ApprovalActionRequest() {}

    public ApprovalActionRequest(String approvalComment, boolean approved, String approvalRole) {
        this.approvalComment = approvalComment;
        this.approved = approved;
        this.approvalRole = approvalRole;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public String getApprovalRole() {
        return approvalRole;
    }

    public void setApprovalRole(String approvalRole) {
        this.approvalRole = approvalRole;
    }
}
