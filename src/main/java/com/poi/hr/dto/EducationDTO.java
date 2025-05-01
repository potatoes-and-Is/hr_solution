package com.poi.hr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class EducationDTO {
    private String schoolName;
    private LocalDate entranceDate;
    private LocalDate graduationDate;
    private String graduationStatus;
    @JsonProperty("createdBy")
    private String createdBy;

    public EducationDTO(String schoolName, LocalDate entranceDate, LocalDate graduationDate, String graduationStatus, String createdBy) {
        this.schoolName = schoolName;
        this.entranceDate = entranceDate;
        this.graduationDate = graduationDate;
        this.graduationStatus = graduationStatus;
        this.createdBy = createdBy;
    }

    public EducationDTO() {}

    // Getter and Setter
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public LocalDate getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(LocalDate entranceDate) {
        this.entranceDate = entranceDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationStatus() {
        return graduationStatus;
    }

    public void setGraduationStatus(String graduationStatus) {
        this.graduationStatus = graduationStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createbBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "EducationDTO{" +
                "schoolName='" + schoolName + '\'' +
                ", entranceDate=" + entranceDate +
                ", graduationDate=" + graduationDate +
                ", graduationStatus='" + graduationStatus + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}

