package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDocs;
import com.poi.hr.domain.approval.VacationReq;
import com.poi.hr.dto.ApprovalDetailDto;
import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.VacationReqRepository;
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
        System.out.println("!!! 서비스 접근 !!!");
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
        Optional<ApprovalDocs> approvalDoc = approvalRepository.findById(id);
        Optional<VacationReq> vacationReq = vacationReqRepository.findById(id);

        ApprovalDetailDto approvalDetailDto = new ApprovalDetailDto(
                approvalDoc.get().getApprovalDocId(),
                approvalDoc.get().getDocType().getDocTypeName(),
                approvalDoc.get().getApprovalTitle(),
                approvalDoc.get().getCreatedAt(),
                approvalDoc.get().getApprovalDate(),
                approvalDoc.get().getApprovalContent(),
                approvalDoc.get().getApprovalReason(),

                vacationReq.get().getVacReqStart(),
                vacationReq.get().getVacReqEnd(),
                vacationReq.get().getVacUseDay()
        );

        return approvalDetailDto;
    }
}
