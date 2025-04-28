package com.poi.hr.dto;

import jakarta.persistence.Entity;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Validated
public class DeptDTO {
    private Integer deptId;
    private String deptCode;
    private String deptName;
    private String createdBy;
    private String updatedBy;
    private Integer parentDeptId;

    private List<DeptDTO> children = new ArrayList<>();

    public DeptDTO() {
    }

    public DeptDTO(int deptId, String deptName, String createdBy, String updatedBy, Integer parentDeptId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.parentDeptId = parentDeptId;
    }

    public DeptDTO(int deptId, String deptCode, String deptName, String createdBy, String updatedBy, Integer parentDeptId) {
        this.deptId = deptId;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.parentDeptId = parentDeptId;
    }

    public DeptDTO(String deptCode, String deptName) {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    public Integer getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(Integer parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public List<DeptDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptDTO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "DeptDTO{" +
                "deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", parentDeptId=" + parentDeptId + '\'' +
                ", children=" + children +
                '}';
    }
}