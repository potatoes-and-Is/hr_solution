package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalLineDto {

    private int approvalLineId;
    private int approvalDocId;
    private int employeeId;
    private String approvalTitle;
    private int approvalLineOrder;

    public ApprovalLineDto() {
    }

    public ApprovalLineDto(int approvalLineId, int approvalDocId, int employeeId, String approvalTitle, int approvalLineOrder, LocalDate createdAt) {
        this.approvalLineId = approvalLineId;
        this.approvalDocId = approvalDocId;
        this.employeeId = employeeId;
        this.approvalTitle = approvalTitle;
        this.approvalLineOrder = approvalLineOrder;
        this.createdAt = createdAt;
    }

    public int getApprovalLineId() {
        return approvalLineId;
    }

    public void setApprovalLineId(int approvalLineId) {
        this.approvalLineId = approvalLineId;
    }

    public int getApprovalDocId() {
        return approvalDocId;
    }

    public void setApprovalDocId(int approvalDocId) {
        this.approvalDocId = approvalDocId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getApprovalTitle() {
        return approvalTitle;
    }

    public void setApprovalTitle(String approvalTitle) {
        this.approvalTitle = approvalTitle;
    }

    public int getApprovalLineOrder() {
        return approvalLineOrder;
    }

    public void setApprovalLineOrder(int approvalLineOrder) {
        this.approvalLineOrder = approvalLineOrder;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
