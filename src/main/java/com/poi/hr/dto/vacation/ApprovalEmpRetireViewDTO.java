package com.poi.hr.dto.vacation;

import com.poi.hr.dto.DeptDTO;

import java.util.List;

public class ApprovalEmpRetireViewDTO {

    private List<DeptDTO> deptList; // deptList 필드 타입을 DeptDTO로 수정

    public List<DeptDTO> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<DeptDTO> deptList) {
        this.deptList = deptList;
    }
}






