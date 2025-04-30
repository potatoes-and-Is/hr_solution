package com.poi.hr.dto.approval;

import com.poi.hr.domain.approval.DocType;

public class ApprovalDto {

    private DocType docType;
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;

    public ApprovalDto() {
    }

    public ApprovalDto(DocType docType, String approvalTitle, String approvalContent, String approvalReason) {
        this.docType = docType;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
    }

    public DocType getDocType() {
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

    public void setDocType(DocType docType) {
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
}
