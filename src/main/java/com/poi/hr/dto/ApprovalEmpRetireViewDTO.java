package com.poi.hr.dto;

import com.poi.hr.domain.dept.Dept;

import java.util.List;

public class ApprovalEmpRetireViewDTO {

    private String leaveType; // 자유 기입을 위한 String 필드
    private List<Dept> deptList; // DeptDTO에서 deptName 값을 가져옴

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }
}





