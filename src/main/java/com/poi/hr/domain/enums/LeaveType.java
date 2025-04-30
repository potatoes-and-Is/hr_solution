package com.poi.hr.domain.enums;

public enum LeaveType {
    SICK("병가"),
    MATERNITY("육아휴직"),
    PERSONAL("개인사정"),
    ETC("기타");

    private final String type;

    LeaveType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
