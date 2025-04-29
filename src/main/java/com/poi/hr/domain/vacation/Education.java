package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int educationId;

    @Column(name = "school_name", nullable = false, length = 30)
    private String schoolName;

    @Column(name = "entrance_date", nullable = false)
    private LocalDate entranceDate;

    @Column(name = "graduation_date", nullable = false)
    private LocalDate graduationDate;

    @Column(name = "graduation_status", nullable = false, length = 20)
    private String graduationStatus;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Education() {

    }

    public Education(String schoolName, LocalDate entranceDate, LocalDate graduationDate, String graduationStatus, String createdBy, Employee employee) {
        this.schoolName = schoolName;
        this.entranceDate = entranceDate;
        this.graduationDate = graduationDate;
        this.graduationStatus = graduationStatus;
        this.createdBy = createdBy;
        this.employee = employee;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationStatus() {
        return graduationStatus;
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

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setEntranceDate(LocalDate entranceDate) {
        this.entranceDate = entranceDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setGraduationStatus(String graduationStatus) {
        this.graduationStatus = graduationStatus;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", schoolName='" + schoolName + '\'' +
                ", entranceDate=" + entranceDate +
                ", graduationDate=" + graduationDate +
                ", graduationStatus='" + graduationStatus + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}