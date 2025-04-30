package com.poi.hr.service;

import com.poi.hr.domain.approval.ApprovalHistory;
import com.poi.hr.domain.approval.ApprovalLine;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import com.poi.hr.dto.approval.ApprovalHistorySaveDto;
import com.poi.hr.repository.approval.ApprovalHistoryRepository;
import com.poi.hr.repository.approval.ApprovalLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalHistoryService {

    private ApprovalHistoryRepository approvalHistoryRepository;
    private ApprovalLineRepository approvalLineRepository;

    public ApprovalHistoryService(ApprovalHistoryRepository approvalHistoryRepository, ApprovalLineRepository approvalLineRepository) {
        this.approvalHistoryRepository = approvalHistoryRepository;
        this.approvalLineRepository = approvalLineRepository;
    }

    public void saveApprovalHistory(ApprovalHistorySaveDto approvalHistorySaveDto) {
        // 1. 결재라인 조회
        ApprovalLine approvalLine = approvalLineRepository.findById(approvalHistorySaveDto.getApprovalLineId())
                .orElseThrow(() -> new IllegalArgumentException("결재라인을 찾을 수 없습니다."));

        // 2. 결재내역 저장
        ApprovalHistory approvalHistory = new ApprovalHistory(
                approvalHistorySaveDto.getComment(),
                approvalHistorySaveDto.getApprovalDocStatus(),
                approvalLine
        );
        approvalHistoryRepository.save(approvalHistory);

        // 3. 결재 승계 처리
        if (approvalHistorySaveDto.getApprovalDocStatus() == ApprovalDocStatus.APPROVED) {
            moveToNextApproval(approvalLine);
        }
        // 만약 반려(REJECTED)면 따로 승계 안 하고 끝낸다.
    }

    private void moveToNextApproval(ApprovalLine currentLine) {
        int approvalDocId = currentLine.getApprovalDoc().getApprovalDocId();

        // 현재 문서의 전체 결재라인 조회 (order 순으로 정렬)
        List<ApprovalLine> approvalLines = approvalLineRepository.findByApprovalDoc_ApprovalDocIdOrderByApprovalLineOrderAsc(approvalDocId);

        // 현재 결재자의 order 찾기
        int currentOrder = currentLine.getApprovalLineOrder();

        // 다음 결재자 찾기
        ApprovalLine nextApprover = approvalLines.stream()
                .filter(line -> line.getApprovalLineOrder() == currentOrder + 1)
                .findFirst()
                .orElse(null);

        if (nextApprover == null) {
            // 다음 결재자가 없다 → 모든 결재 완료 → 문서 최종 승인 처리
            approveFinalDocument(approvalDocId);
        } else {
            // 다음 결재자 결재 차례 → 필요 시 알림 로직 추가 가능
            // ex) NotificationService.sendTo(nextApprover)
        }
    }

    private void approveFinalDocument(int approvalDocId) {
        // 여기서 문서 최종 승인 처리 로직 구현
        // ex) ApprovalDocRepository 사용해서 문서 상태를 APPROVED로 변경
        // (아직 ApprovalDoc 테이블, ApprovalDoc 엔티티, Repository가 준비되어야 여기 작성 가능)

        System.out.println("문서 ID " + approvalDocId + " 최종 승인 완료 처리");
    }
}