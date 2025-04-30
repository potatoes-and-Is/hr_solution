package com.poi.hr.domain.approval;

import com.poi.hr.domain.login.entity.Employee;
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

    @Column(name = "approval_role", nullable = false, length = 30)
    private String approvalRole;

    @Column(name = "approval_line_order", nullable = false)
    private int approvalLineOrder;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public ApprovalLine() {

    }

    public ApprovalLine(ApprovalDoc approvalDoc, Employee employee, String approvalRole, int approvalLineOrder) {
        this.approvalDoc = approvalDoc;
        this.employee = employee;
        this.approvalRole = approvalRole;
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

    public String getApprovalRole() {
        return approvalRole;
    }

    public int getApprovalLineOrder() {
        return approvalLineOrder;
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

    public void setApprovalRole(String approvalRole) {
        this.approvalRole = approvalRole;
    }

    public void setApprovalLineOrder(int approvalLineOrder) {
        this.approvalLineOrder = approvalLineOrder;
    }

    @Override
    public String toString() {
        return "ApprovalLine{" +
                "approvalLineId=" + approvalLineId +
                ", approvalDocId=" + (approvalDoc != null ? approvalDoc.getApprovalDocId() : null) +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", approvalRole='" + approvalRole + '\'' +
                ", approvalLineOrder=" + approvalLineOrder +
                ", createdAt=" + createdAt +
                '}';
    }
}