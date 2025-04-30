package com.poi.hr.service.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.VacationReq;
import com.poi.hr.dto.approval.ApprovalVacResponseDto;
import com.poi.hr.repository.approval.ApprovalRepository;
import com.poi.hr.repository.vacation.VacationReqRepository;
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

                vacationReq.getVacReqStartDate(),
                vacationReq.getVacReqEndDate(),
                vacationReq.getVacUseDays()
        );
    }
}
