package com.poi.hr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Date;

public class LanguageDTO {
    private String languageName;
    private Integer  score;
    private String languageOrg;
    private LocalDate acquisitionDate;
    private LocalDate expirationDate;
    @JsonProperty("createdBy")
    private String createdBy;

    public LanguageDTO() {}

    public LanguageDTO(String languageName, Integer  score, String languageOrg, LocalDate acquisitionDate, LocalDate expirationDate, String createdBy) {
        this.languageName = languageName;
        this.score = score;
        this.languageOrg = languageOrg;
        this.acquisitionDate = acquisitionDate;
        this.expirationDate = expirationDate;
        this.createdBy = createdBy;
    }

    // Getter and Setter
    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageOrg() {
        return languageOrg;
    }

    public void setLanguageOrg(String languageOrg) {
        this.languageOrg = languageOrg;
    }

    public Integer  getScore() {
        return score;
    }

    public void setScore(Integer  score) {
        this.score = score;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "LanguageDTO{" +
                "languageName='" + languageName + '\'' +
                ", score=" + score +
                ", languageOrg='" + languageOrg + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", expirationDate=" + expirationDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
