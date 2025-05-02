package com.poi.hr.dto;

import org.springframework.validation.annotation.Validated;

@Validated
public class ResponseDeptDTO {
    private Integer deptId;
    private String deptName;

    public ResponseDeptDTO(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() { return deptId; }
    public String getDeptName() { return deptName; }
}
