package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalDoc;
import com.poi.hr.domain.approval.ApprovalLine;
import com.poi.hr.domain.enums.ApprovalDocStatus;
import com.poi.hr.domain.hr.Employee;
import com.poi.hr.dto.ApprovalLineSaveDto;
import com.poi.hr.repository.ApprovalLineRepository;
import com.poi.hr.repository.ApprovalRepository;
import com.poi.hr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApprovalLineService {

    private final ApprovalLineRepository approvalLineRepository;
    private final ApprovalRepository approvalRepository;
    private final EmployeeRepository employeeRepository;

    public ApprovalLineService(ApprovalLineRepository approvalLineRepository, ApprovalRepository approvalRepository, EmployeeRepository employeeRepository) {
        this.approvalLineRepository = approvalLineRepository;
        this.approvalRepository = approvalRepository;
        this.employeeRepository = employeeRepository;
    }

    public void saveApprovalLine(List<ApprovalLineSaveDto> approvalLineSaveDtoList) {
        ApprovalDoc approvalDoc =  approvalRepository.findById(approvalLineSaveDtoList.get(0).getApprovalDocId())
                .orElseThrow(() -> new IllegalArgumentException("해당 결재 문서가 없습니다."));
        List<ApprovalLine> approvalLines = new ArrayList<>();

        int aprrovalLineOrder = 1;
        for (ApprovalLineSaveDto approvalLineSaveDto : approvalLineSaveDtoList) {
            approvalLines.add(new ApprovalLine(
                    approvalDoc,
                    employeeRepository.findById(approvalLineSaveDto.getEmployeeId()).orElse(null),
                    ApprovalDocStatus.PENDING,
                    aprrovalLineOrder
            ));
            aprrovalLineOrder++;
        }

        approvalLineRepository.saveAll(approvalLines);
    }
}
