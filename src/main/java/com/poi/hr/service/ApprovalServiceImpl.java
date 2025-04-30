package com.poi.hr.service;

import com.poi.hr.dto.ApprovalEmpLeaveViewDTO;
import com.poi.hr.dto.ApprovalEmpLeaveViewDTO.DepartmentDto;
import com.poi.hr.dto.ApprovalEmpLeaveSaveDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Override
    public ApprovalEmpLeaveViewDTO getLeaveFormData() {
        ApprovalEmpLeaveViewDTO dto = new ApprovalEmpLeaveViewDTO();

        dto.setLeaveTypeList(Arrays.asList(ApprovalEmpLeaveViewDTO.LeaveType.values()));

        DepartmentDto sales = new DepartmentDto("sales", "영업부");
        DepartmentDto hr = new DepartmentDto("hr", "인사부");
        DepartmentDto it = new DepartmentDto("it", "개발부");

        dto.setDeptList(Arrays.asList(sales, hr, it));
        return dto;
    }

    @Override
    public void saveLeaveApproval(ApprovalEmpLeaveSaveDTO dto) {
        System.out.println("Saving Leave Approval:");
        System.out.println(dto);
    }
}


