package com.poi.hr.service;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.ApprovalEmpRetireViewDTO;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.repository.DeptRepository;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {
    private static EmployeeRepository employeeRepository = null;

    @Autowired
    private DeptRepository deptRepository; // DeptRepository 주입

    public ApprovalService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 퇴직 결재 폼 데이터를 조회하는 메서드
    public ApprovalEmpRetireViewDTO getLeaveFormData() {
        ApprovalEmpRetireViewDTO dto = new ApprovalEmpRetireViewDTO();

        // 데이터베이스에서 부서 리스트를 가져옴
        List<DeptDTO> deptDTOList = deptRepository.findAll().stream()
                .map(dept -> new DeptDTO(dept.getDeptCode(), dept.getDeptName())) // Dept -> DeptDTO 변환
                .collect(Collectors.toList());

        // 부서 리스트를 DTO에 설정
        dto.setDeptList(deptDTOList);

        return dto;
    }

    // 퇴직 결재 문서를 저장하는 로직
    public void saveLeaveApproval(ApprovalEmpRetireSaveDTO dto) {
        // 실제 로직 구현 (예: DB에 저장)
        System.out.println("Saving Leave Approval: " + dto);
    }

    // 부서에 해당하는 직원 목록을 가져옵니다
    public static List<EmployeeRequestDTO> getEmployeesByDepartment(String department) {
        return employeeRepository.getEmployeesByDepartment(department);
    }

    // 직원 상세 정보를 가져옵니다
    public static EmployeeRequestDTO getEmployeeDetail(int employeeId) {
        return employeeRepository.getEmployeeDetail(employeeId);
    }

    // 다음 직원 번호를 가져옵니다
    public static int getNextEmployeeNumber() {
        return employeeRepository.findNextEmployeeNumber();
    }
}















