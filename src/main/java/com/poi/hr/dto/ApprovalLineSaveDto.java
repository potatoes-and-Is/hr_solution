package com.poi.hr.dto;

import java.time.LocalDate;

public class ApprovalLineSaveDto {

    private int approvalDocId;
    private int employeeId;

    public ApprovalLineSaveDto() {
    }

    public ApprovalLineSaveDto(int approvalDocId, int employeeId, String approvalRole) {
        this.approvalDocId = approvalDocId;
        this.employeeId = employeeId;
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
}
