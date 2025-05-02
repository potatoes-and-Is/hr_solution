package com.poi.hr.service;

import com.poi.hr.dto.vacation.ApprovalViewDTO;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.repository.DeptRepository;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.vacation.RetireReqRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalDocService {
    private final EmployeeRepository employeeRepository;
    private final DeptRepository deptRepository;
    private final RetireReqRepository retireReqRepository;

    public ApprovalDocService(EmployeeRepository employeeRepository, DeptRepository deptRepository, RetireReqRepository retireReqRepository) {
        this.employeeRepository = employeeRepository;
        this.deptRepository = deptRepository;
        this.retireReqRepository = retireReqRepository;
    }

    // 퇴직 결재 폼 데이터를 조회하는 메서드
    public ApprovalViewDTO getLeaveFormData() {
        ApprovalViewDTO dto = new ApprovalViewDTO();

        // 데이터베이스에서 부서 리스트를 가져옴
        List<DeptDTO> deptDTOList = deptRepository.findAll().stream()
                .map(dept -> new DeptDTO(dept.getDeptCode(), dept.getDeptName())) // Dept -> DeptDTO 변환
                .collect(Collectors.toList());

        // 부서 리스트를 DTO에 설정
        dto.setDeptList(deptDTOList);

        return dto;
    }

    public List<EmployeeRequestDTO> getEmployeesByDepartment(String department) {
        return employeeRepository.getEmployeesByDepartment(department);
    }

    public EmployeeRequestDTO getEmployeeDetail(int employeeId) {
        return employeeRepository.getEmployeeDetail(employeeId);
    }

    public int getNextEmployeeNumber() {
        return employeeRepository.findNextEmployeeNumber();
    }
}















