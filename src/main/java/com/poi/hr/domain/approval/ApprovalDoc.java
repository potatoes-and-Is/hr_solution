package com.poi.hr.domain.approval;

import com.poi.hr.domain.enums.ApprovalDocStatus;
import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "approval_docs")
public class ApprovalDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_doc_id")
    private int approvalDocId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id", nullable = false)
    private DocType docType;

    @Column(name = "approval_title", nullable = false)
    private String approvalTitle;

    @Lob
    @Column(name = "approval_content", nullable = false, length = 65535)
    private String approvalContent;

    @Column(name = "approval_reason", nullable = false)
    private String approvalReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalDocStatus approvalStatus = ApprovalDocStatus.PENDING;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    public ApprovalDoc() {
    }

    public ApprovalDoc(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason) {
        this.employee = employee;
        this.docType = docType;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
    }

    public int getApprovalDocId() {
        return approvalDocId;
    }

    public Employee getEmployee() {
        return employee;
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

    public ApprovalDocStatus getApprovalStatus() {
        return approvalStatus;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setApprovalDocId(int approvalDocId) {
        this.approvalDocId = approvalDocId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public void setApprovalStatus(ApprovalDocStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setApprovalDate(LocalDate approvalDate) {
        this.approvalDate = approvalDate;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ApprovalDocs{" +
                "approvalDocId=" + approvalDocId +
                ", employee=" + employee +
                ", docType=" + docType +
                ", approvalTitle='" + approvalTitle + '\'' +
                ", approvalContent='" + approvalContent + '\'' +
                ", approvalReason='" + approvalReason + '\'' +
                ", approvalStatus=" + approvalStatus +
                ", approvalDate=" + approvalDate +
                ", createdAt=" + createdAt +
                '}';
    }
}