package com.poi.hr.service;

import com.poi.hr.dto.ApprovalEmpLeaveViewDTO;
import com.poi.hr.dto.ApprovalEmpLeaveSaveDTO;

public interface ApprovalService {
    ApprovalEmpLeaveViewDTO getLeaveFormData();
    void saveLeaveApproval(ApprovalEmpLeaveSaveDTO dto);
}

