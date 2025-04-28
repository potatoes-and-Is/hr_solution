package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Vacation_grant_histories")
public class VacationGrantHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vac_grant_id")
    private int vacGrantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vac_type_id")
    private VacationType vacationType;

    @Column(name = "granted_days", nullable = false)
    private Double grantedDays;

    @Column(name = "grant_date", nullable = false)
    private LocalDate grantDate;

    @Column(name = "grant_type", nullable = false, length = 30)
    private String grantType;

    @Column(name = "grant_comment", length = 50)
    private String grantComment;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public VacationGrantHistory() {

    }

    public VacationGrantHistory(Employee employee, VacationType vacationType, Double grantedDays, LocalDate grantDate, String grantType, String grantComment) {
        this.employee = employee;
        this.vacationType = vacationType;
        this.grantedDays = grantedDays;
        this.grantDate = grantDate;
        this.grantType = grantType;
        this.grantComment = grantComment;
    }

    public int getVacGrantId() {
        return vacGrantId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public Double getGrantedDays() {
        return grantedDays;
    }

    public LocalDate getGrantDate() {
        return grantDate;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getGrantComment() {
        return grantComment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    public void setGrantedDays(Double grantedDays) {
        this.grantedDays = grantedDays;
    }

    public void setGrantDate(LocalDate grantDate) {
        this.grantDate = grantDate;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public void setGrantComment(String grantComment) {
        this.grantComment = grantComment;
    }

    @Override
    public String toString() {
        return "VacationGrantHistory{" +
                "vacGrantId=" + vacGrantId +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", vacationTypeId=" + (vacationType != null ? vacationType.getVacTypeId() : null) +
                ", grantedDays=" + grantedDays +
                ", grantDate=" + grantDate +
                ", grantType='" + grantType + '\'' +
                ", grantComment='" + grantComment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}