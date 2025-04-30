package com.poi.hr.domain.attendance;

public enum AttendStatus {

    WORK("정상"),
    LATE("지각"),
    EARLY_LEAVE("조퇴"),
    VACATION("휴가");

    private final String displayName;

    AttendStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
