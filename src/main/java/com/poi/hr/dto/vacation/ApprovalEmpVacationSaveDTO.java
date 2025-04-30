package com.poi.hr.dto.vacation;

import java.time.LocalDate;
import java.util.List;

public class ApprovalEmpVacationSaveDTO {

    private String approvalTitle;          // 결재 제목
    private String approvalContent;        // 결재 내용
    private String approvalReason;         // 결재 사유
    private LocalDate vacReqStart;         // 휴가 시작일
    private LocalDate vacReqEnd;           // 휴가 종료일
    private String vacType;                // 휴가 유형 (연차, 병가 등)
    private String vacUseDays;             // 사용한 휴가 일수
    private List<Integer> approverList;    // 결재자 ID 리스트

    // Getters and Setters
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

    public LocalDate getVacReqStart() {
        return vacReqStart;
    }

    public void setVacReqStart(LocalDate vacReqStart) {
        this.vacReqStart = vacReqStart;
    }

    public LocalDate getVacReqEnd() {
        return vacReqEnd;
    }

    public void setVacReqEnd(LocalDate vacReqEnd) {
        this.vacReqEnd = vacReqEnd;
    }

    public String getVacType() {
        return vacType;
    }

    public void setVacType(String vacType) {
        this.vacType = vacType;
    }

    public String getVacUseDays() {
        return vacUseDays;
    }

    public void setVacUseDays(String vacUseDays) {
        this.vacUseDays = vacUseDays;
    }

    public List<Integer> getApproverList() {
        return approverList;
    }

    public void setApproverList(List<Integer> approverList) {
        this.approverList = approverList;
    }
}

