package com.poi.hr.dto.approval;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ApprovalFixAttendSaveDTO {

    private String docTypeCode;
    private String approvalTitle;
    private String approvalContent;
    private String approvalReason;
    private int attendId;
    private LocalDate attendDate;
    private LocalTime originCheckInTime;
    private LocalTime originCheckOutTime;
    private LocalTime newCheckInTime;
    private LocalTime newCheckOutTime;
    private List<ApprovalLineSaveDto> approvalLineList;

    public ApprovalFixAttendSaveDTO() {

    }

    public ApprovalFixAttendSaveDTO(String docTypeCode, String approvalTitle, String approvalContent, String approvalReason, int attendId, LocalDate attendDate, LocalTime originCheckInTime, LocalTime originCheckOutTime, LocalTime newCheckInTime, LocalTime newCheckOutTime, List<ApprovalLineSaveDto> approvalLineList) {
        this.docTypeCode = docTypeCode;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
        this.attendId = attendId;
        this.attendDate = attendDate;
        this.originCheckInTime = originCheckInTime;
        this.originCheckOutTime = originCheckOutTime;
        this.newCheckInTime = newCheckInTime;
        this.newCheckOutTime = newCheckOutTime;
        this.approvalLineList = approvalLineList;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
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

    public int getAttendId() {
        return attendId;
    }

    public void setAttendId(int attendId) {
        this.attendId = attendId;
    }

    public LocalDate getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(LocalDate attendDate) {
        this.attendDate = attendDate;
    }

    public LocalTime getOriginCheckInTime() {
        return originCheckInTime;
    }

    public void setOriginCheckInTime(LocalTime originCheckInTime) {
        this.originCheckInTime = originCheckInTime;
    }

    public LocalTime getOriginCheckOutTime() {
        return originCheckOutTime;
    }

    public void setOriginCheckOutTime(LocalTime originCheckOutTime) {
        this.originCheckOutTime = originCheckOutTime;
    }

    public LocalTime getNewCheckInTime() {
        return newCheckInTime;
    }

    public void setNewCheckInTime(LocalTime newCheckInTime) {
        this.newCheckInTime = newCheckInTime;
    }

    public LocalTime getNewCheckOutTime() {
        return newCheckOutTime;
    }

    public void setNewCheckOutTime(LocalTime newCheckOutTime) {
        this.newCheckOutTime = newCheckOutTime;
    }

    public List<ApprovalLineSaveDto> getApprovalLineList() {
        return approvalLineList;
    }

    public void setApprovalLineList(List<ApprovalLineSaveDto> approvalLineList) {
        this.approvalLineList = approvalLineList;
    }
}
