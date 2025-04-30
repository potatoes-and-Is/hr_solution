package com.poi.hr.domain.vacation.enums;

public enum LeaveType {
    SICK("병가"),
    MATERNITY("육아휴직"),
    PERSONAL("개인사정"),
    ETC("기타");

    private final String displayName;

    LeaveType(String type) {
        this.displayName = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
