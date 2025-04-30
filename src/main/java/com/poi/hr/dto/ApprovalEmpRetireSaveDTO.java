package com.poi.hr.dto;

import java.time.LocalDate;
import java.util.List;

public class ApprovalEmpRetireSaveDTO {
    private String approvalTitle;       // 제목
    private String approvalContent;     // 내용
    private String approvalReason;      // 사유
    private LocalDate retireDate;       // 퇴직일
    private String retireType;          // 퇴직 종류
    private List<String> approverList;  // 결재자 ID 또는 이름 목록

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

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public String getRetireType() {
        return retireType;
    }

    public void setRetireType(String retireType) {
        this.retireType = retireType;
    }

    public List<String> getApproverList() {
        return approverList;
    }

    public void setApproverList(List<String> approverList) {
        this.approverList = approverList;
    }
}

