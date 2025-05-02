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
    private int approvalHistoryId;

    @Column(name = "approval_comment", length = 255)
    private String approvalComment;

    @Column(name = "approval_role", nullable = false, length = 30)
    private String approvalRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_line_id")
    private ApprovalLine approvalLine;

    @Column(name = "approval_date", nullable = false, insertable = false, updatable = false)
    private LocalDateTime approvalDate;

    public ApprovalHistory() {

    }

    public ApprovalHistory(String approvalComment, String approvalRole, ApprovalLine approvalLine) {
        this.approvalComment = approvalComment;
        this.approvalRole = approvalRole;
        this.approvalLine = approvalLine;
    }

    public int getApprovalHistoryId() {
        return approvalHistoryId;
    }

    public String getApprovalComment() {
        return approvalComment;
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

    public String getApprovalRole() {
        return approvalRole;
    }

    public void setApprovalRole(String approvalRole) {
        this.approvalRole = approvalRole;
    }

    public void setApprovalLine(ApprovalLine approvalLine) {
        this.approvalLine = approvalLine;
    }

    @Override
    public String toString() {
        return "ApprovalHistory{" +
                "approvalHistoryId=" + approvalHistoryId +
                ", approvalComment='" + approvalComment + '\'' +
                ", approvalRole=" + approvalRole +
                ", approvalLineId=" + (approvalLine != null ? approvalLine.getApprovalLineId() : null ) +
                ", approvalDate=" + approvalDate +
                '}';
    }
}