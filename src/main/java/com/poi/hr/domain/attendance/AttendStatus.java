package com.poi.hr.domain.attendance;

public enum AttendStatus {

    WORK("정상"),
    LATE("지각"),
    EARLY_LEAVE("조퇴"),
    VACATION("휴가");

    private String value;

    AttendStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
