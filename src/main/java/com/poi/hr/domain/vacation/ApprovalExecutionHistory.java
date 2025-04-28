package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Approval_execution_histories")
public class ApprovalExecutionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "execution_id")
    private int executionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_doc_id")
    private ApprovalDoc approvalDoc;

    @Column(name = "execution_type", nullable = false, length = 30)
    private String executionType;

    @Column(name = "execution_status", nullable = false, length = 30)
    private String executionStatus;

    @Column(name = "executed_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime executedAt;

    @Column(name = "executed_by", length = 30)
    private String executedBy;

    @Column(name = "comment")
    private String comment;

    public ApprovalExecutionHistory() {

    }

    public ApprovalExecutionHistory(ApprovalDoc approvalDoc, String executionType, String executionStatus, String executedBy, String comment) {
        this.approvalDoc = approvalDoc;
        this.executionType = executionType;
        this.executionStatus = executionStatus;
        this.executedBy = executedBy;
        this.comment = comment;
    }

    public int getExecutionId() {
        return executionId;
    }

    public ApprovalDoc getApprovalDoc() {
        return approvalDoc;
    }

    public String getExecutionType() {
        return executionType;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }

    public String getExecutedBy() {
        return executedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setApprovalDoc(ApprovalDoc approvalDoc) {
        this.approvalDoc = approvalDoc;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public void setExecutedBy(String executedBy) {
        this.executedBy = executedBy;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ApprovalExecutionHistory{" +
                "executionId=" + executionId +
                ", approvalDocId=" + (approvalDoc != null ? approvalDoc.getApprovalDocId() : null) +
                ", executionType='" + executionType + '\'' +
                ", executionStatus='" + executionStatus + '\'' +
                ", executedAt=" + executedAt +
                ", executedBy='" + executedBy + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}