package com.poi.hr.service;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;
import com.poi.hr.repository.DeptRepository; // 부서 조회 Repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalService {

    @Autowired
    private DeptRepository deptRepository;  // 부서 Repository

    public ApprovalEmpRetireViewDTO getLeaveFormData() {
        ApprovalEmpRetireViewDTO dto = new ApprovalEmpRetireViewDTO();

        // 퇴직 종류는 자유 입력 필드로 처리

        // 부서 리스트를 DB에서 가져오기
        List<Dept> deptList = deptRepository.findAll(); // DB에서 부서 정보 조회

        dto.setDeptList(deptList); // DB에서 가져온 부서 리스트를 DTO에 세팅

        return dto;
    }

    public void saveLeaveApproval(ApprovalEmpRetireSaveDTO dto) {
        // Leave Approval을 저장하는 로직
        System.out.println("Saving Leave Approval:");
        System.out.println(dto);
    }
}








