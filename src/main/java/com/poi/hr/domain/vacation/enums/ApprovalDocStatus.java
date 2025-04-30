package com.poi.hr.domain.vacation.enums;

public enum ApprovalDocStatus {
    PENDING("대기"),
    IN_PROGRESS("진행중"),
    APPROVED("승인"),
    REJECTED("반려"),
    FAILED("취소");

    // 문서 작성시 결재라인별로 PENDING
    // 결재자가 승인/반려 시, IN_PROGRESS, APPROVED, REJECTED
    // 사용자 취소시 CANCELED
    // 마지막 결재자 까지 APPROVED 되면 Approval_execution_histories에 실행 이력 INSERT
    // IN_PROGERSSS는 결재 문서의 상태에서 사용, 결제 내역에서는 사용하지 않음.

    private final String displayName;
    
    ApprovalDocStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
