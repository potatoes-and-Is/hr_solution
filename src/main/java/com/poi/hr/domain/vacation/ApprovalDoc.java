package com.poi.hr.domain.vacation;

import  com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Approval_docs")
public abstract class ApprovalDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_doc_id")
    private int approvalDocId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    private DocType docType;

    @Column(name = "approval_title", nullable = false, length = 50)
    private String approvalTitle;

    @Column(name = "approval_content", nullable = false, length = 255)
    private String approvalContent;

    @Column(name = "approval_reason", nullable = false, length = 255)
    private String approvalReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalDocStatus approvalDocStatus;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    @CreatedDate
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDate createdAt;

    public ApprovalDoc() {

    }

    public ApprovalDoc(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason) {
        this.employee = employee;
        this.docType = docType;
        this.approvalTitle = approvalTitle;
        this.approvalContent = approvalContent;
        this.approvalReason = approvalReason;
        this.approvalDocStatus = ApprovalDocStatus.PENDING; // 생성시 기본 상태
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

    public ApprovalDocStatus getApprovalDocStatus() {
        return approvalDocStatus;
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
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

    public void setApprovalDocStatus(ApprovalDocStatus approvalDocStatus) {
        this.approvalDocStatus = approvalDocStatus;
    }

    @Override
    public String toString() {
        return "ApprovalDoc{" +
                "approvalDocId=" + approvalDocId +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", docTypeId=" + (docType != null ? docType.getDocTypeId() : null) +
                ", approvalTitle='" + approvalTitle + '\'' +
                ", approvalContent='" + approvalContent + '\'' +
                ", approvalReason='" + approvalReason + '\'' +
                ", approvalDocStatus=" + approvalDocStatus +
                ", approvalDate=" + approvalDate +
                ", createdAt=" + createdAt +
                '}';
    }

}
