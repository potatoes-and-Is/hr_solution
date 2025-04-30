package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDocs;
import com.poi.hr.domain.approval.LeaveReq;
import com.poi.hr.domain.approval.VacationReq;
import com.poi.hr.dto.ApprovalDto;
import com.poi.hr.dto.ApprovalEmpLeaveDto;
import com.poi.hr.dto.ApprovalVacDto;
import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.LeaveReqRepository;
import com.poi.hr.repository.VacationReqRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final VacationReqRepository vacationReqRepository;
    private final LeaveReqRepository leaveReqRepository;

    public ApprovalService(ApprovalRepository approvalRepository, VacationReqRepository vacationReqRepository, LeaveReqRepository leaveReqRepository) {
        this.approvalRepository = approvalRepository;
        this.vacationReqRepository = vacationReqRepository;
        this.leaveReqRepository = leaveReqRepository;
    }

    /* 모든 결재문서 조회 */
    public List<ApprovalListDto> findAllApprovals() {
        List<ApprovalListDto> approvalListDto = new ArrayList<>();
        for (ApprovalDocs approvalDocs : approvalRepository.findAll()) {
            approvalListDto.add(new ApprovalListDto(
                    approvalDocs.getApprovalDocId(),
                    approvalDocs.getDocType().getDocTypeName(),
                    approvalDocs.getApprovalTitle(),
                    approvalDocs.getCreatedAt(),
                    approvalDocs.getApprovalDate(),
                    approvalDocs.getApprovalStatus()));
        }

        return approvalListDto;
    }

    /* 한개의 결재문서(부모) 조회 */
    public ApprovalDto findById(int id) {
        ApprovalDocs approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));

        return new ApprovalDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getStatus(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason()
        );
    }

    /* 휴가 신청 조회 */
    public ApprovalVacDto findApprovalVacById(int id) {
        ApprovalDocs approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));
        VacationReq vacationReq = vacationReqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 휴가 요청이 없습니다."));

        return new ApprovalVacDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getStatus(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason(),

                vacationReq.getVacReqStart(),
                vacationReq.getVacReqEnd(),
                vacationReq.getVacUseDay()
        );
    }

    /* 휴직 신청 조회 */
    public ApprovalEmpLeaveDto findApprovalEmpLeaveById(int id) {
        ApprovalDocs approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));
        LeaveReq leaveReq = leaveReqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 휴가 요청이 없습니다."));

        return new ApprovalEmpLeaveDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getStatus(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason(),

                leaveReq.getLeaveStartDate(),
                leaveReq.getLeaveEndDate(),
                leaveReq.getLeaveType().getType()
        );
    }

//    /* 휴직 데이터 저장 */
//    public ApprovalEmpLeaveDto saveApprovalEmpLeave(ApprovalEmpLeaveDto approvalEmpLeaveDto) {
//
//    }
}
