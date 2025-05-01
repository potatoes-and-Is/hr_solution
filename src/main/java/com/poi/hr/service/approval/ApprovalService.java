package com.poi.hr.service.approval;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.ApprovalHistory;
import com.poi.hr.domain.vacation.ApprovalLine;
import com.poi.hr.dto.approval.ApprovalActionRequest;
import com.poi.hr.dto.approval.ApprovalDetailDto;
import com.poi.hr.dto.approval.ApprovalListDto;
import com.poi.hr.dto.approval.ApprovalMyListDto;
import com.poi.hr.repository.approval.ApprovalLineRepository;
import com.poi.hr.repository.approval.ApprovalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final ApprovalLineRepository approvalLineRepository;

    public ApprovalService(ApprovalRepository approvalRepository, ApprovalLineRepository approvalLineRepository) {
        this.approvalRepository = approvalRepository;
        this.approvalLineRepository = approvalLineRepository;
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

    /* 내게 온 결재 - 승인/반려 처리 */
//    @Transactional
//    public void processApprovalAction(int approvalDocId, int approverId, ApprovalActionRequest request) {
//        // 1. 결재라인 정보 조회
//        ApprovalLine line = approvalLineRepository
//                .findByApprovalDocIdAndEmployeeId(approvalDocId, approverId)
//                .orElseThrow(() -> new RuntimeException("결재라인 정보 없음"));
//
//        // 2. 결재의견 저장
//        ApprovalHistory history = new ApprovalHistory();
//        history.setApprovalLine(line);

//        history.setApprovalRole(line.getApprovalRole()); // 예: "2차승인자"
//        history.setApprovalComment(request.getApprovalComment());
//        approvalHistoryRepository.save(history);


        // 3. 다음 결재자 있는지 판단

        // 4. 결재문서 상태 변경

        // 5. 이후 처리 (휴가, 출퇴근요청 등 자식 테이블 상태 변경 함수 호출)

//    }

    /* 내게 온 결재문서 목록 조회 */
    public List<ApprovalMyListDto> findMyApprovals(int currentUserId) {
        return approvalRepository.findAll().stream()
                .filter(doc -> doc.getEmployee().getEmployeeId() == currentUserId)
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
}
