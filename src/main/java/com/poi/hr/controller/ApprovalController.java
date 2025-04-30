package com.poi.hr.controller;

import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.DeptDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    // 부서 리스트나 퇴직 데이터를 처리하는 로직을 작성합니다.
    public ApprovalEmpRetireViewDTO getLeaveFormData() {
        ApprovalEmpRetireViewDTO dto = new ApprovalEmpRetireViewDTO();

        // 데이터베이스에서 부서 목록을 가져오거나, 하드코딩을 할 수 있습니다.
        // 예시로 하드코딩된 부서 리스트 설정
        DeptDTO sales = new DeptDTO("sales", "영업부");
        DeptDTO hr = new DeptDTO("hr", "인사부");
        DeptDTO it = new DeptDTO("it", "개발부");

        dto.setDeptList(List.of(sales, hr, it));

        return dto;
    }

    public void saveLeaveApproval(ApprovalEmpRetireSaveDTO dto) {
        // 퇴직 결재 데이터를 저장하는 로직
        System.out.println("Saving Leave Approval:");
        System.out.println(dto);
    }
}

