package com.poi.hr.dto;

public enum LeaveType {
    SICK_LEAVE("병가"),
    MATERNITY_LEAVE("출산휴가"),
    PERSONAL_LEAVE("개인휴가");

    private final String displayName;

    LeaveType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
