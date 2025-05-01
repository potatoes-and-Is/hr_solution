package com.poi.hr.service.approval;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.ApprovalHistory;
import com.poi.hr.domain.vacation.ApprovalLine;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import com.poi.hr.dto.approval.ApprovalActionRequest;
import com.poi.hr.dto.approval.ApprovalDetailDto;
import com.poi.hr.dto.approval.ApprovalListDto;
import com.poi.hr.dto.approval.ApprovalMyListDto;
import com.poi.hr.repository.approval.ApprovalHistoryRepository;
import com.poi.hr.repository.approval.ApprovalLineRepository;
import com.poi.hr.repository.approval.ApprovalRepository;
import com.poi.hr.util.SecurityUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.poi.hr.domain.vacation.enums.ApprovalDocStatus.*;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final ApprovalLineRepository approvalLineRepository;
    private final ApprovalHistoryRepository approvalHistoryRepository;
    private final ApprovalEmpLeaveService approvalEmpLeaveService;


    public ApprovalService(ApprovalRepository approvalRepository, ApprovalLineRepository approvalLineRepository, ApprovalHistoryRepository approvalHistoryRepository, ApprovalEmpLeaveService approvalEmpLeaveService) {
        this.approvalRepository = approvalRepository;
        this.approvalLineRepository = approvalLineRepository;
        this.approvalHistoryRepository = approvalHistoryRepository;
        this.approvalEmpLeaveService = approvalEmpLeaveService;
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

    /* 내게 온 결재문서 목록 조회 */
    @Transactional
    public List<ApprovalMyListDto> findMyApprovals() {
        int currentUserId = SecurityUtil.getCurrentEmployeeId();
        List<ApprovalDoc> docs = approvalLineRepository.findPendingDocsForMyApproval(currentUserId);

        return docs.stream()
                .map(doc -> new ApprovalMyListDto(
                        doc.getApprovalDocId(),
                        doc.getDocType().getDocTypeName(),
                        doc.getApprovalTitle(),
                        doc.getEmployee().getEmployeeName(),
                        doc.getCreatedAt(),
                        doc.getApprovalStatus()
                ))
                .collect(Collectors.toList());
    }

    /* 내게 온 결재 - 승인/반려 처리 */
    @Transactional
    public void processApprovalAction(int approvalDocId, int approverId, ApprovalActionRequest request) {
        // 1. 결재라인 정보 조회
        ApprovalLine line = approvalLineRepository
                .findApprovalLine(approvalDocId, approverId)
                .orElseThrow(() -> new RuntimeException("결재라인 정보 없음"));

        // 2. 결재의견 저장
        String approvalRole = getRoleFromOrder(line.getApprovalLineOrder());
        ApprovalHistory history = new ApprovalHistory();
        history.setApprovalLine(line);
        history.setApprovalComment(request.getApprovalComment());
        history.setApprovalRole(approvalRole);

        approvalHistoryRepository.save(history);

        // 3. 현재 결재자 상태 변경
        line.setApprovalStatus(request.isApproved() ? APPROVED : REJECTED);
        approvalLineRepository.save(line);

        // 4. 다음 결재자가 있는지 확인
        List<ApprovalLine> lines = approvalLineRepository.findLinesByApprovalDocIdOrdered(approvalDocId);

        boolean isLastApprover = true;
        for (ApprovalLine l : lines) {
            if (l.getApprovalLineOrder() > line.getApprovalLineOrder() && l.getApprovalStatus() ==  ApprovalDocStatus.PENDING) {
                isLastApprover = false;
                break;
            }
        }

        System.out.println("다음 결재자 있는지 확인했나아아아아아");

        // 5. 결재문서 상태 변경
        ApprovalDoc doc = line.getApprovalDoc();
        if (request.isApproved()) {
            if (isLastApprover) {
                doc.setApprovalStatus(APPROVED);
                doc.setApprovalDate(LocalDate.now());

                // 6. 자식 테이블 후처리
                switch (doc.getDocType().getDocTypeCode()) {
                    case "LEAVE_REQUEST" -> approvalEmpLeaveService.processApprovedLeave(doc);
//                    case "VACATION_REQUEST" -> approvalVacService.processApprovedVacation(doc);
                    // case "ATTENDANCE_FIX_REQUEST" -> attendanceFixService.applyFix(doc);

                }
            } else {
                doc.setApprovalStatus(IN_PROGRESS);
            }
        } else {
            doc.setApprovalStatus(REJECTED);
        }

        approvalRepository.save(doc);

        System.out.println("다 저장되었찌로오오오오오");

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

    /* 결재 목록 출력 (내가 작성한 것만) */
    public List<ApprovalListDto> findApprovalsByWriter(int writerId) {
        return approvalRepository.findAll().stream()
                .filter(doc -> doc.getEmployee().getEmployeeId() == writerId)
                .map(doc -> new ApprovalListDto(
                        doc.getApprovalDocId(),
                        doc.getDocType().getDocTypeName(),
                        doc.getApprovalTitle(),
                        doc.getCreatedAt(),
                        doc.getApprovalDate(),
                        doc.getApprovalStatus()
                )).collect(Collectors.toList());
    }
}