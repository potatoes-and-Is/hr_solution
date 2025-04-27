package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDocs;
import com.poi.hr.domain.approval.VacationReq;
import com.poi.hr.dto.ApprovalDetailDto;
import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.VacationReqRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final VacationReqRepository vacationReqRepository;

    public ApprovalService(ApprovalRepository approvalRepository, VacationReqRepository vacationReqRepository) {
        this.approvalRepository = approvalRepository;
        this.vacationReqRepository = vacationReqRepository;
    }

    public List<ApprovalListDto> findAllApprovals() {
        approvalRepository.findAll();

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

    public ApprovalDetailDto findApprovalById(int id) {
        ApprovalDocs approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));
        VacationReq vacationReq = vacationReqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 휴가 요청이 없습니다."));

        return new ApprovalDetailDto(
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
}
