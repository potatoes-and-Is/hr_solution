package com.poi.hr.service;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.ApprovalLine;
import com.poi.hr.domain.vacation.DocType;
import com.poi.hr.domain.vacation.RetireReq;
import com.poi.hr.dto.vacation.ApprovalEmpRetireSaveDTO;
import com.poi.hr.dto.vacation.ApprovalViewDTO;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.dto.EmployeeRequestDTO;
import com.poi.hr.repository.DeptRepository;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.vacation.ApprovalLineRepository;
import com.poi.hr.repository.vacation.DocTypeRepository;
import com.poi.hr.repository.vacation.RetireReqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {
    private final EmployeeRepository employeeRepository;
    private final DeptRepository deptRepository;
    private final RetireReqRepository retireReqRepository;
    private final DocTypeRepository docTypeRepository;
    private final ApprovalLineRepository approvalLineRepository;

    @Autowired

    public ApprovalService(EmployeeRepository employeeRepository, DeptRepository deptRepository, RetireReqRepository retireReqRepository, DocTypeRepository docTypeRepository, ApprovalLineRepository approvalLineRepository) {
        this.employeeRepository = employeeRepository;
        this.deptRepository = deptRepository;
        this.retireReqRepository = retireReqRepository;
        this.docTypeRepository = docTypeRepository;
        this.approvalLineRepository = approvalLineRepository;
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

    public void saveLeaveApproval(ApprovalEmpRetireSaveDTO dto, int writerId) {
        Employee writer = employeeRepository.findById(writerId)
                .orElseThrow(() -> new IllegalArgumentException("작성자 정보 없음"));

        DocType docType = docTypeRepository.findByDocTypeName("RETIRE_REQUEST")
                .orElseThrow(() -> new RuntimeException("문서 타입 '퇴직'을 찾을 수 없습니다."));

        RetireReq retireReq = new RetireReq();
        retireReq.setEmployee(writer);  // 퇴직 대상자 = 로그인한 본인
        retireReq.setRetireType(dto.getRetireType());  // 중복 제거
        retireReq.setApprovalTitle(dto.getApprovalTitle());
        retireReq.setApprovalContent(dto.getApprovalContent());
        retireReq.setApprovalReason(dto.getApprovalReason());
        retireReq.setRetireDate(dto.getRetireDate());

        RetireReq savedReq = retireReqRepository.save(retireReq); // 문서 먼저 저장

        List<Integer> approverIds = dto.getApproverList();
        for (int i = 0; i < approverIds.size(); i++) {
            int approverId = approverIds.get(i);
            Employee approver = employeeRepository.findById(approverId)
                    .orElseThrow(() -> new IllegalArgumentException("결재자 정보 없음"));

            ApprovalLine line = new ApprovalLine();
            line.setApprovalDoc(savedReq);  // 여기서 RetireReq 넘김
            line.setEmployee(approver);
            line.setApprovalRole("결재자");
            line.setApprovalLineOrder(i + 1);
            approvalLineRepository.save(line);
        }
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















