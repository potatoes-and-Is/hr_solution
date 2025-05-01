package com.poi.hr.dto.vacation;

import java.time.LocalDateTime;

public class ApprovalEmpAttendanceSaveDTO {

    // 출근 수정 요청 (Attendance fix request)
    private Integer approvalDocId;    // 결재 문서 ID
    private Integer attendId;         // 근무 ID
    private Integer reqCheckInTime;   // 출근 수정 요청 시간
    private Integer reqCheckOutTime;  // 퇴근 수정 요청 시간
    private Integer employeeId;       // 직원 ID

    // 결재 문서 (Approval document)
    private Integer docTypeId;        // 결재 문서 유형 ID
    private String approvalTitle;     // 결재 제목
    private String approvalContent;   // 결재 내용
    private String approvalReason;    // 결재 사유
    private String approvalStatus;    // 결재 상태
    private LocalDateTime approvalDate; // 결재 일자
    private LocalDateTime createdAt;  // 등록 일자

    // Getters and Setters

    public Integer getApprovalDocId() {
        return approvalDocId;
    }

    public void setApprovalDocId(Integer approvalDocId) {
        this.approvalDocId = approvalDocId;
    }

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public Integer getReqCheckInTime() {
        return reqCheckInTime;
    }

    public void setReqCheckInTime(Integer reqCheckInTime) {
        this.reqCheckInTime = reqCheckInTime;
    }

    public Integer getReqCheckOutTime() {
        return reqCheckOutTime;
    }

    public void setReqCheckOutTime(Integer reqCheckOutTime) {
        this.reqCheckOutTime = reqCheckOutTime;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDocTypeId() {
        return docTypeId;
    }

    public void setDocTypeId(Integer docTypeId) {
        this.docTypeId = docTypeId;
    }

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

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

