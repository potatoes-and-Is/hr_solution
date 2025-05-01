package com.poi.hr.service.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.DocType;
import com.poi.hr.domain.vacation.EmployeeLeave;
import com.poi.hr.domain.vacation.LeaveReq;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.enums.LeaveType;
import com.poi.hr.dto.approval.ApprovalEmpLeaveResponseDto;
import com.poi.hr.dto.approval.ApprovalEmpLeaveSaveDto;
import com.poi.hr.repository.EmployeeLeaveRepository;
import com.poi.hr.repository.approval.ApprovalRepository;
import com.poi.hr.repository.approval.DocTypeRepository;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.approval.LeaveReqRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ApprovalEmpLeaveService {

    private final ApprovalRepository approvalRepository;
    private final LeaveReqRepository leaveReqRepository;
    private final EmployeeRepository employeeRepository;
    private final DocTypeRepository docTypeRepository;
    private final EmployeeLeaveRepository employeeLeaveRepository;

    public ApprovalEmpLeaveService(ApprovalRepository approvalRepository,
                                   LeaveReqRepository leaveReqRepository,
                                   EmployeeRepository employeeRepository,
                                   DocTypeRepository docTypeRepository,
                                   EmployeeLeaveRepository employeeLeaveRepository) {
        this.approvalRepository = approvalRepository;
        this.leaveReqRepository = leaveReqRepository;
        this.employeeRepository = employeeRepository;
        this.docTypeRepository = docTypeRepository;
        this.employeeLeaveRepository = employeeLeaveRepository;
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
        System.out.println("service!! 저장 시작");
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
        System.out.println("서비스!!! 타입 확인" + docType.getDocTypeName());
        leaveReqRepository.save(leaveReq);

        approvalEmpLeaveSaveDto.getApprovalLineList().get(0).setApprovalDocId(leaveReq.getApprovalDocId());

    }

    /* 결재 승인 후 - 휴직 데이터 업데이트 */
    @Transactional
    public void processApprovedLeave(ApprovalDoc approvalDoc) {
        LeaveReq leaveReq = leaveReqRepository.findByApprovalDocId(approvalDoc.getApprovalDocId())
                .orElseThrow(() -> new EntityNotFoundException("휴직 데이터 없음"));

        // 결재 승인될 때 EmployeeLeave 직접 생성하기 (휴직 데이터 저장. 현재 휴직요청에만 데이터 있음)
//        Employee employee = approvalDoc.getEmployee();
//
//        EmployeeLeave employeeLeave = new EmployeeLeave(
//
//
//                approvalDoc,
//                employee,
//                leaveReq.getLeaveStartDate(),
//                leaveReq.getLeaveEndDate(),
//                leaveReq.getLeaveType()
//        );

//        employeeLeaveRepository.save(leaveReq);
    }



}
