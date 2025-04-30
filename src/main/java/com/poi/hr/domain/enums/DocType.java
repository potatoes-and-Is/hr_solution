package com.poi.hr.domain.enums;

public enum DocType {
    VACATION_REQUEST("휴가신청"),
    ATTEND_FIX_REQUEST("출퇴근정정신청"),
    LEAVE_REQUEST("휴직신청"),
    RETIRE_REQUEST("퇴직신청");

    private final String displayName;

    DocType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}