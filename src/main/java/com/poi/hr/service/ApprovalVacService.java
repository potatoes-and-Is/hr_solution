package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDoc;
import com.poi.hr.domain.approval.VacationReq;
import com.poi.hr.dto.ApprovalVacResponseDto;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.VacationReqRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApprovalVacService {

    private final ApprovalRepository approvalRepository;
    private final VacationReqRepository vacationReqRepository;

    public ApprovalVacService(ApprovalRepository approvalRepository, VacationReqRepository vacationReqRepository) {
        this.approvalRepository = approvalRepository;
        this.vacationReqRepository = vacationReqRepository;
    }

    /* 휴가 신청 조회 */
    public ApprovalVacResponseDto findApprovalVacById(int id) {
        ApprovalDoc approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));
        VacationReq vacationReq = vacationReqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 휴가 신청이 없습니다."));

        return new ApprovalVacResponseDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeCode(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getDisplayName(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason(),

                vacationReq.getVacReqStart(),
                vacationReq.getVacReqEnd(),
                vacationReq.getVacUseDay()
        );
    }
}
