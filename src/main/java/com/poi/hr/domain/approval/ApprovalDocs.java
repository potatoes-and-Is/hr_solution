package com.poi.hr.domain.approval;

import com.poi.hr.domain.enums.ApprovalDocStatus;
import com.poi.hr.domain.hr.Employee;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "approval_docs")
public abstract class ApprovalDocs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}