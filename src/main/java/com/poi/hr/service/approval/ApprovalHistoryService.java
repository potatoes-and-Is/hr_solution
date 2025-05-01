package com.poi.hr.service.approval;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.ApprovalExecutionHistory;
import com.poi.hr.domain.vacation.ApprovalHistory;
import com.poi.hr.domain.vacation.ApprovalLine;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import com.poi.hr.dto.approval.ApprovalHistorySaveDto;
import com.poi.hr.repository.approval.ApprovalExecutionHistoryRepository;
import com.poi.hr.repository.approval.ApprovalHistoryRepository;
import com.poi.hr.repository.approval.ApprovalLineRepository;
import com.poi.hr.repository.vacation.ApprovalDocRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ApprovalHistoryService {

    private final ApprovalLineRepository approvalLineRepository;
    private final ApprovalHistoryRepository approvalHistoryRepository;
    private final ApprovalDocRepository approvalDocRepository;
    private final ApprovalExecutionHistoryRepository approvalExecutionHistoryRepository;

    public ApprovalHistoryService(ApprovalLineRepository approvalLineRepository, ApprovalHistoryRepository approvalHistoryRepository, ApprovalDocRepository approvalDocRepository, ApprovalExecutionHistoryRepository approvalExecutionHistoryRepository) {
        this.approvalLineRepository = approvalLineRepository;
        this.approvalHistoryRepository = approvalHistoryRepository;
        this.approvalDocRepository = approvalDocRepository;
        this.approvalExecutionHistoryRepository = approvalExecutionHistoryRepository;
    }

    // 결재자가 승인, 반려 버튼 눌렀을 때 실행
    public void saveApprovalHistory(ApprovalHistorySaveDto dto) {
        // 1. 결재라인 조회
        ApprovalLine approvalLine = approvalLineRepository.findById(dto.getApprovalLineId())
                .orElseThrow(() -> new IllegalArgumentException("결재라인을 찾을 수 없습니다."));

        // 2. 결재 상태 업데이트
        approvalLine.setApprovalStatus(dto.getApprovalDocStatus());
        approvalLineRepository.save(approvalLine);

        // 3. 결재내역 저장 (상태는 저장하지 않고 역할 + 코멘트만)
        String approvalRole = getRoleFromOrder(approvalLine.getApprovalLineOrder());
        ApprovalHistory approvalHistory = new ApprovalHistory(
                dto.getApprovalComment(),
                approvalRole,
                approvalLine
        );
        approvalHistoryRepository.save(approvalHistory);

        // 4. 승인인 경우 → 다음 결재자 승계 흐름
        if (dto.getApprovalDocStatus() == ApprovalDocStatus.APPROVED) {
            handleNextApprovalOrFinalize(approvalLine);
        }
    }

    // 다음 결재자 승계 처리 or 최종 승인 처리
    private void handleNextApprovalOrFinalize(ApprovalLine currentLine) {
        int currentOrder = currentLine.getApprovalLineOrder();
        int approvalDocId = currentLine.getApprovalDoc().getApprovalDocId();

        // 결재문서의 전체 결재라인 가져오기 (순서대로)
        List<ApprovalLine> lines = approvalLineRepository
                .findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(approvalDocId);

        // 다음 결재자 찾기
        ApprovalLine nextLine = lines.stream()
                .filter(line -> line.getApprovalLineOrder() == currentOrder + 1)
                .findFirst()
                .orElse(null);

        if (nextLine == null) {
            // 다음 결재자 없음 → 문서 최종 승인 처리
            finalizeApprovalDocument(approvalDocId);
        }
        // 다음 결재자 있을 경우는 다음 차례이므로 특별한 처리는 없음
    }

    // 모든 결재가 완료되었을 때 문서를 최종 승인 처리
    private void finalizeApprovalDocument(int approvalDocId) {
        // 1. 문서 조회
        ApprovalDoc doc = approvalDocRepository.findById(approvalDocId)
                .orElseThrow(() -> new RuntimeException("결재문서를 찾을 수 없습니다."));

        // 2. 전체 결재라인 조회 (순서대로)
        List<ApprovalLine> lines = approvalLineRepository
                .findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(approvalDocId);

        // 3. 실행 상태 및 처리자 결정
        String executionStatus;
        String executedBy;

        boolean hasReject = lines.stream()
                .anyMatch(line -> line.getApprovalStatus() == ApprovalDocStatus.REJECTED);

        if (hasReject) {
            // 반려된 경우
            executionStatus = "FAILED";
            executedBy = lines.stream()
                    .filter(line -> line.getApprovalStatus() == ApprovalDocStatus.REJECTED)
                    .findFirst()
                    .map(line -> line.getEmployee().getEmployeeName())
                    .orElse("UNKNOWN");

            doc.setApprovalStatus(ApprovalDocStatus.REJECTED);

        } else {
            // 모두 승인된 경우
            executionStatus = "SUCCESS";
            executedBy = lines.get(lines.size() - 1).getEmployee().getEmployeeName(); // 마지막 승인자 이름

            doc.setApprovalStatus(ApprovalDocStatus.APPROVED);
            doc.setApprovalDate(LocalDate.now());
        }

        // 4. 실행유형: 문서유형 코드 사용
        String executionType = doc.getDocType().getDocTypeCode(); // 예: "vacation_request"

        // 5. 문서 상태 저장
        approvalDocRepository.save(doc);

        // 6. 실행이력 저장
        ApprovalExecutionHistory history = new ApprovalExecutionHistory(
                doc,
                executionType,
                executionStatus,
                executedBy,
                "문서 결재 최종 상태 처리됨"
        );
        approvalExecutionHistoryRepository.save(history);

        System.out.println("문서 ID " + approvalDocId + " 최종 상태: " + executionStatus + ", 처리자: " + executedBy);
    }

    // 결재 순서 → 역할 매핑
    private String getRoleFromOrder(int order) {
        return switch (order) {
            case 1 -> "1차승인자";
            case 2 -> "2차승인자";
            case 3 -> "3차승인자";
            default -> order + "차승인자";
        };
    }
}
