package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Retire_reqs")
public class RetireReq extends ApprovalDoc {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "retire_date", nullable = false)
    private LocalDate retireDate;

    @Column(name = "retire_type", nullable = false, length = 30)
    private String retireType;

    public RetireReq() {

    }

    public RetireReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, Employee employee1, LocalDate retireDate, String retireType) {
        super(employee, docType, approvalTitle, approvalContent, approvalReason);
        this.employee = employee1;
        this.retireDate = retireDate;
        this.retireType = retireType;
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public String getRetireType() {
        return retireType;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public void setRetireType(String retireType) {
        this.retireType = retireType;
    }

    @Override
    public String toString() {
        return "RetireReq{" +
                "employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", retireDate=" + retireDate +
                ", retireType='" + retireType + '\'' +
                '}';
    }
}
