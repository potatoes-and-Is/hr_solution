package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;

    @Column(name = "language_name", length = 100)
    private String languageName;

    @Column(name = "score")
    private int score;

    @Column(name = "language_org", length = 30)
    private String languageOrg;

    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Language() {

    }

    public Language(String languageName, int score, String languageOrg, LocalDate acquisitionDate, LocalDate expirationDate, String createdBy, Employee employee) {
        this.languageName = languageName;
        this.score = score;
        this.languageOrg = languageOrg;
        this.acquisitionDate = acquisitionDate;
        this.expirationDate = expirationDate;
        this.createdBy = createdBy;
        this.employee = employee;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public int getScore() {
        return score;
    }

    public String getLanguageOrg() {
        return languageOrg;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
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

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLanguageOrg(String languageOrg) {
        this.languageOrg = languageOrg;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
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
        return "Language{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                ", score=" + score +
                ", languageOrg='" + languageOrg + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", expirationDate=" + expirationDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}