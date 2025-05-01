package com.poi.hr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CareerDTO {
    private String previousCompany;
    private String previousDeptName;
    private String previousLevel;
    private String retireReason;
    @JsonProperty("createdBy")
    private String createdBy;

    public CareerDTO() {}

    public CareerDTO(String previousCompany, String previousDeptName, String previousLevel, String retireReason, String createdBy) {
        this.previousCompany = previousCompany;
        this.previousDeptName = previousDeptName;
        this.previousLevel = previousLevel;
        this.retireReason = retireReason;
        this.createdBy = createdBy;
    }

    // Getter and Setter
    public String getPreviousCompany() {
        return previousCompany;
    }

    public void setPreviousCompany(String previousCompany) {
        this.previousCompany = previousCompany;
    }

    public String getPreviousDeptName() {
        return previousDeptName;
    }

    public void setPreviousDeptName(String previousDeptName) {
        this.previousDeptName = previousDeptName;
    }

    public String getPreviousLevel() {
        return previousLevel;
    }

    public void setPreviousLevel(String previousLevel) {
        this.previousLevel = previousLevel;
    }

    public String getRetireReason() {
        return retireReason;
    }

    public void setRetireReason(String retireReason) {
        this.retireReason = retireReason;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "previousCompany='" + previousCompany + '\'' +
                ", previousDeptName='" + previousDeptName + '\'' +
                ", previousLevel='" + previousLevel + '\'' +
                ", retireReason='" + retireReason + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
