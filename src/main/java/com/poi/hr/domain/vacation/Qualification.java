package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Qualifications")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualification_id")
    private int qualificationId;

    @Column(name = "qualification_name", length = 30)
    private String qualificationName;

    @Column(name = "certificate_org", length = 100)
    private String certificateOrg;

    @Column(name = "certificate_date")
    private LocalDate certificateDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Qualification() {

    }

    public Qualification(String qualificationName, String certificateOrg, LocalDate certificateDate, LocalDate expirationDate, String createdBy, Employee employee) {
        this.qualificationName = qualificationName;
        this.certificateOrg = certificateOrg;
        this.certificateDate = certificateDate;
        this.expirationDate = expirationDate;
        this.createdBy = createdBy;
        this.employee = employee;
    }

    public int getQualificationId() {
        return qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public String getCertificateOrg() {
        return certificateOrg;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public void setCertificateOrg(String certificateOrg) {
        this.certificateOrg = certificateOrg;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "qualificationId=" + qualificationId +
                ", qualificationName='" + qualificationName + '\'' +
                ", certificateOrg='" + certificateOrg + '\'' +
                ", certificateDate=" + certificateDate +
                ", expirationDate=" + expirationDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}
