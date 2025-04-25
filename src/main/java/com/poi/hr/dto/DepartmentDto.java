package com.poi.hr.dto;

public class DepartmentDto {

    private String deptCode;
    private String deptName;
    private String createdBy;
    private String updatedBy;
    private String parentCode;

    public DepartmentDto() {
    }

    public DepartmentDto(String deptCode, String deptName, String createdBy, String updatedBy, String parentCode) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.parentCode = parentCode;
    }

    public DepartmentDto(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        return "DeptsDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", parentCode='" + parentCode + '\'' +
                '}';
    }


}