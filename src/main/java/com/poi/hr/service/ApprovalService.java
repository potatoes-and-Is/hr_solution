package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDoc;
import com.poi.hr.dto.ApprovalDetailDto;
import com.poi.hr.dto.ApprovalListDto;
import com.poi.hr.repository.ApprovalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;

    public ApprovalService(ApprovalRepository approvalRepository) {
        this.approvalRepository = approvalRepository;
    }

    /* 모든 결재문서 조회 */
    public List<ApprovalListDto> findAllApprovals() {
        List<ApprovalListDto> approvalListDto = new ArrayList<>();
        for (ApprovalDoc approvalDocs : approvalRepository.findAll()) {
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
    public ApprovalDetailDto findById(int id) {
        ApprovalDoc approvalDoc = approvalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 결재 문서가 없습니다."));

        return new ApprovalDetailDto(
                approvalDoc.getApprovalDocId(),
                approvalDoc.getDocType().getDocTypeCode(),
                approvalDoc.getDocType().getDocTypeName(),
                approvalDoc.getApprovalTitle(),
                approvalDoc.getCreatedAt(),
                approvalDoc.getApprovalDate(),
                approvalDoc.getApprovalStatus().getDisplayName(),
                approvalDoc.getApprovalContent(),
                approvalDoc.getApprovalReason()
        );
    }
}
