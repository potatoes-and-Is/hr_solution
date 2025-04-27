package com.poi.hr.domain.vacation;

import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import jakarta.persistence.*;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

@Entity
@Table(name = "Approval_histories")
public class ApprovalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_history_id")
    private Integer approvalHistoryId;

    @Column(name = "approval_comment", length = 255)
    private String approvalComment;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalDocStatus approvalStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_line_id")
    private ApprovalLine approvalLine;

    @Column(name = "approval_date", nullable = false, insertable = false, updatable = false)
    private LocalDateTime approvalDate;

    public ApprovalHistory() {

    }

    public ApprovalHistory(String approvalComment, ApprovalDocStatus approvalStatus, ApprovalLine approvalLine) {
        this.approvalComment = approvalComment;
        this.approvalStatus = approvalStatus;
        this.approvalLine = approvalLine;
    }

    public Integer getApprovalHistoryId() {
        return approvalHistoryId;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public ApprovalDocStatus getApprovalStatus() {
        return approvalStatus;
    }

    public ApprovalLine getApprovalLine() {
        return approvalLine;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public void setApprovalStatus(ApprovalDocStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setApprovalLine(ApprovalLine approvalLine) {
        this.approvalLine = approvalLine;
    }

    @Override
    public String toString() {
        return "ApprovalHistory{" +
                "approvalHistoryId=" + approvalHistoryId +
                ", approvalComment='" + approvalComment + '\'' +
                ", approvalStatus=" + approvalStatus +
                ", approvalLineId=" + (approvalLine != null ? approvalLine.getApprovalLineId() : null ) +
                ", approvalDate=" + approvalDate +
                '}';
    }
}