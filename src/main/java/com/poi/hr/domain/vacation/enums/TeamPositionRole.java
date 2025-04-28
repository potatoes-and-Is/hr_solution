package com.poi.hr.domain.vacation.enums;

public enum TeamPositionRole {
    TEAM_MEMBER("팀원"),
    TEAM_LEADER("팀장"),
    DEPT_LEADER("부서장"),
    HR_MEMBER("인사 팀원"),
    HR_LEADER("인사 팀장"),
    CEO("대표");

    private final String displayName;

    private TeamPositionRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}