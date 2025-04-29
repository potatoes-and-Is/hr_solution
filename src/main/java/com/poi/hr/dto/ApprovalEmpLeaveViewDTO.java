package com.poi.hr.dto;

import java.util.ArrayList;
import java.util.List;

public class ApprovalEmpLeaveViewDTO {

    private List<LeaveType> leaveTypeList;
    private List<DeptDTO> deptList;

    public ApprovalEmpLeaveViewDTO() {
        // 휴직 종류 리스트
        this.leaveTypeList = new ArrayList<>();
        leaveTypeList.add(LeaveType.SICK_LEAVE);
        leaveTypeList.add(LeaveType.MATERNITY_LEAVE);
        leaveTypeList.add(LeaveType.PERSONAL_LEAVE);

        // 부서 리스트
        this.deptList = new ArrayList<>();
        deptList.add(new DeptDTO("sales", "영업팀"));
        deptList.add(new DeptDTO("hr", "인사팀"));
        deptList.add(new DeptDTO("it", "개발팀"));
    }

    public List<LeaveType> getLeaveTypeList() {
        return leaveTypeList;
    }

    public void setLeaveTypeList(List<LeaveType> leaveTypeList) {
        this.leaveTypeList = leaveTypeList;
    }

    public List<DeptDTO> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<DeptDTO> deptList) {
        this.deptList = deptList;
    }
}

