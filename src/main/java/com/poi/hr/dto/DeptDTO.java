package com.poi.hr.dto;

public class DeptDTO {
    private int deptId;
    private String deptName;

    public DeptDTO(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() { return deptId; }
    public String getDeptName() { return deptName; }
}
