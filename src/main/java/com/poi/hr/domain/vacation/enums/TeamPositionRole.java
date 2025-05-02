package com.poi.hr.domain.vacation.enums;

public enum TeamPositionRole {
    TEAM_LEADER("팀장"),
    TEAM_MEMBER("팀원"),
    DEPT_LEADER("부서장"),
    HR_MEMBER("인사팀원"),
    HR_LEADER("인사팀장"),
    CEO("대표");

    private final String roleName;

    TeamPositionRole(String role) {
        this.roleName = role;
    }

    public String getRoleName() {
        return roleName;
    }

}