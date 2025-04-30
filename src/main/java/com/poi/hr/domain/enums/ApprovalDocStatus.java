package com.poi.hr.domain.enums;

public enum ApprovalDocStatus {
    PENDING("대기"),
    IN_PROGRESS("진행중"),
    APPROVED("승인"),
    REJECTED("반려"),
    FAILED("취소");

    private final String displayName;

    ApprovalDocStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
