package com.poi.hr.domain.enums;

public enum ApprovalDocStatus {
    PENDING("대기"),
    IN_PROGRESS("진행중"),
    APPROVED("승인"),
    REJECTED("반려"),
    FAILED("취소");

    private final String status;

    ApprovalDocStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
