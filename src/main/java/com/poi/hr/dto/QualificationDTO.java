package com.poi.hr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class QualificationDTO {
    private String qualificationName;
    private String certificateOrg;
    private LocalDate certificateDate;
    private LocalDate expirationDate;
    @JsonProperty("createdBy")
    private String createdBy;

    public QualificationDTO() {}

    public QualificationDTO(String qualificationName, String certificateOrg, LocalDate certificateDate, LocalDate expirationDate, String createdBy) {
        this.qualificationName = qualificationName;
        this.certificateOrg = certificateOrg;
        this.certificateDate = certificateDate;
        this.expirationDate = expirationDate;
        this.createdBy = createdBy;
    }

    // Getter and Setter
    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }

    public String getCertificateOrg() {
        return certificateOrg;
    }

    public void setCertificateOrg(String certificateOrg) {
        this.certificateOrg = certificateOrg;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "QualificationDTO{" +
                "qualificationName='" + qualificationName + '\'' +
                ", certificateOrg='" + certificateOrg + '\'' +
                ", certificateDate=" + certificateDate +
                ", expirationDate=" + expirationDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}

