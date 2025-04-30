package com.poi.hr.repository;

import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;

public interface ApprovalRepository {
    ApprovalEmpRetireViewDTO getLeaveFormData(); // 퇴직 결재 폼 데이터를 조회
    void saveLeaveApproval(ApprovalEmpRetireSaveDTO dto); // 퇴직 결재 문서 저장
}


