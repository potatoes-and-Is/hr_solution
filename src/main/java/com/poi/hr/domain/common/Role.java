package com.poi.hr.domain.common;

public enum Role {
    TEAM_LEADER("팀장"),
    TEAM_MEMBER("팀원"),
    DEPT_LEADER("부서장"),
    HR_MEMBER("인사팀장"),
    HR_LEADER("인사팀원"),
    CEO("대표");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}