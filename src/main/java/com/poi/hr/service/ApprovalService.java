package com.poi.hr.service;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.dto.vacation.ApprovalDTO;
import com.poi.hr.repository.vacation.ApprovalDocRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {

    private final ApprovalDocRepository approvalDocRepository;

    public ApprovalService(ApprovalDocRepository approvalDocRepository) {
        this.approvalDocRepository = approvalDocRepository;
    }

    //결제문서 목록 가져오기
    public List<ApprovalDTO> getAlldocuments() {
        List<ApprovalDoc> approvalDocs = approvalDocRepository.findAll();

        return approvalDocs.stream()
                .map(doc -> new ApprovalDTO(
                        doc.getApprovalDocId(),
                        doc.getApprovalTitle(),
                        doc.getEmployee().getEmployeeName(),  // Employee 객체에서 이름 추출
                        doc.getDocType().getDocTypeName(),    // DocType 객체에서 이름 추출
                        doc.getApprovalDocStatus().name(),    // Enum -> String
                        doc.getCreatedAt(),
                        doc.getApprovalDate()
                ))
                .collect(Collectors.toList());
    }

}
