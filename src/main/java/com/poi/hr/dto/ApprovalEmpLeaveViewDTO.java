package com.poi.hr.dto;

import java.util.List;

public class ApprovalEmpLeaveViewDTO {
    private List<LeaveType> leaveTypeList;
    private List<DepartmentDto> deptList;

    public ApprovalEmpLeaveViewDTO() {

    }

    public static class DepartmentDto {
        private String deptCode;
        private String deptName;

        public DepartmentDto(String deptCode, String deptName) {
            this.deptCode = deptCode;
            this.deptName = deptName;
        }

        public DepartmentDto() {

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
    }

    public enum LeaveType {
        SICK("병가"),
        MATERNITY("출산휴가"),
        PERSONAL("개인사정");

        private final String displayName;

        LeaveType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public ApprovalEmpLeaveViewDTO(List<LeaveType> leaveTypeList, List<DepartmentDto> deptList) {
        this.leaveTypeList = leaveTypeList;
        this.deptList = deptList;
    }

    public List<DepartmentDto> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<DepartmentDto> deptList) {
        this.deptList = deptList;
    }

    public List<LeaveType> getLeaveTypeList() {
        return leaveTypeList;
    }

    public void setLeaveTypeList(List<LeaveType> leaveTypeList) {
        this.leaveTypeList = leaveTypeList;
    }
}


