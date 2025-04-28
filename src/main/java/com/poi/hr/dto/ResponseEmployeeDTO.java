package com.poi.hr.dto;

import org.springframework.validation.annotation.Validated;

@Validated
public class ResponseEmployeeDTO {
    private String employeeName;
    private String deptName;
    private String positionName;
    private String levelName;

    public ResponseEmployeeDTO(String employeeName, String deptName, String positionName, String levelName) {
        this.employeeName = employeeName;
        this.deptName = deptName;
        this.positionName = positionName;
        this.levelName = levelName;
    }

    // Getters
    public String getEmployeeName() { return employeeName; }
    public String getDeptName() { return deptName; }
    public String getPositionName() { return positionName; }
    public String getLevelName() { return levelName; }

    @Override
    public String toString() {
        return "EmployeeInfoDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}
