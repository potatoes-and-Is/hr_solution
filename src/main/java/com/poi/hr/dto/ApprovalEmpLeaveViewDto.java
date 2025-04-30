package com.poi.hr.dto;

import com.poi.hr.domain.enums.LeaveType;
import com.poi.hr.domain.hr.Dept;
import com.poi.hr.domain.hr.Employee;

import java.util.List;

public class ApprovalEmpLeaveViewDto {

    private final List<LeaveType> leaveTypeList;
    private final List<Dept> deptList;

    public ApprovalEmpLeaveViewDto(List<LeaveType> leaveTypeList, List<Dept> deptList) {
        this.leaveTypeList = leaveTypeList;
        this.deptList = deptList;
    }

    public List<LeaveType> getLeaveTypeList() {
        return leaveTypeList;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }
}
