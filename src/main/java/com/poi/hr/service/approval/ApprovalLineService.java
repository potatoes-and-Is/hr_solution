package com.poi.hr.service.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.ApprovalLine;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import com.poi.hr.dto.approval.ApprovalLineSaveDto;
import com.poi.hr.repository.approval.ApprovalLineRepository;
import com.poi.hr.repository.approval.ApprovalRepository;
import com.poi.hr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
