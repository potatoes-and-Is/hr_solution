package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDoc;
import com.poi.hr.domain.approval.DocType;
import com.poi.hr.domain.approval.LeaveReq;
import com.poi.hr.domain.hr.Employee;
import com.poi.hr.dto.ApprovalEmpLeaveResponseDto;
import com.poi.hr.dto.ApprovalEmpLeaveSaveDto;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.DocTypeRepository;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.LeaveReqRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ApprovalEmpLeaveService {

    private final ApprovalRepository approvalRepository;
    private final LeaveReqRepository leaveReqRepository;
    private final EmployeeRepository employeeRepository;
    private final DocTypeRepository docTypeRepository;

    public ApprovalEmpLeaveService(ApprovalRepository approvalRepository, LeaveReqRepository leaveReqRepository, EmployeeRepository employeeRepository, DocTypeRepository docTypeRepository) {
        this.approvalRepository = approvalRepository;
        this.leaveReqRepository = leaveReqRepository;
        this.employeeRepository = employeeRepository;
        this.docTypeRepository = docTypeRepository;
    }

    /* 휴직 신청 조회 */
    public ApprovalEmpLeaveResponseDto findApprovalEmpLeaveById(int id) {
        ApprovalDoc approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));
        LeaveReq leaveReq = leaveReqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 휴직 신청이 없습니다."));

        return new ApprovalEmpLeaveResponseDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeCode(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getDisplayName(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason(),

                leaveReq.getLeaveStartDate(),
                leaveReq.getLeaveEndDate(),
                leaveReq.getLeaveType().getDisplayName()
        );
    }

    /* 휴직 데이터 저장 */
    @Transactional
    public void saveApprovalEmpLeave(ApprovalEmpLeaveSaveDto approvalEmpLeaveSaveDto) {
        // 세션 employee 저장
        Employee employee = employeeRepository.findById(1).orElse(null);
        DocType docType = docTypeRepository.findByDocTypeCode("LEAVE_REQUEST");

        LeaveReq leaveReq = new LeaveReq(
                employee,
                docType,
                approvalEmpLeaveSaveDto.getApprovalTitle(),
                approvalEmpLeaveSaveDto.getApprovalContent(),
                approvalEmpLeaveSaveDto.getApprovalReason(),

                approvalEmpLeaveSaveDto.getLeaveStartDate(),
                approvalEmpLeaveSaveDto.getLeaveEndDate(),
                approvalEmpLeaveSaveDto.getLeaveType()
        );

        leaveReqRepository.save(leaveReq);

        approvalEmpLeaveSaveDto.getApprovalLineList().get(0).setApprovalDocId(leaveReq.getApprovalDocId());

    }
}
