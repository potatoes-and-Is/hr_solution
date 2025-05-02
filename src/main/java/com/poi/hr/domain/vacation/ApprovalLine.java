package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Approval_lines")
public class ApprovalLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_line_id")
    private int approvalLineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval_doc_id")
    private ApprovalDoc approvalDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false, length = 30)
    private ApprovalDocStatus approvalStatus;

    @Column(name = "approval_line_order", nullable = false)
    private int approvalLineOrder;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "image_save", columnDefinition = "LONGTEXT")
    private String imageSave;

    public ApprovalLine() {

    }

    public ApprovalLine(ApprovalDoc approvalDoc, Employee employee, ApprovalDocStatus approvalStatus, int approvalLineOrder) {
        this.approvalDoc = approvalDoc;
        this.employee = employee;
        this.approvalStatus = approvalStatus;
        this.approvalLineOrder = approvalLineOrder;
    }

    public int getApprovalLineId() {
        return approvalLineId;
    }

    public ApprovalDoc getApprovalDoc() {
        return approvalDoc;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getApprovalLineOrder() {
        return approvalLineOrder;
    }

    public String getImageSave() {
        return imageSave;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setApprovalDoc(ApprovalDoc approvalDoc) {
        this.approvalDoc = approvalDoc;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ApprovalDocStatus getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalDocStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setApprovalLineOrder(int approvalLineOrder) {
        this.approvalLineOrder = approvalLineOrder;
    }

    public void setImageSave(String imageSave) {
        this.imageSave = imageSave;
    }
}