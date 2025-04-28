package com.poi.hr.domain.employee;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Team_positions")
public class TeamPositions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_position_id")
    private Integer teamPositionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "position_name", nullable = false, length = 30)
    private String positionName;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // ===== Enum 정의 =====
    public enum Role {
        TEAM_MEMBER,
        TEAM_LEADER,
        DEPT_LEADER,
        HR_MEMBER,
        HR_LEADER,
        CEO
    }

    // ===== 기본 생성자 =====
    public TeamPositions() {
    }

    // ===== 생성자 =====
    public TeamPositions(Role role, String positionName) {
        this.role = role;
        this.positionName = positionName;
    }

    // ===== Getter & Setter =====
    public Integer getTeamPositionId() {
        return teamPositionId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "TeamPositions{" +
                "teamPositionId=" + teamPositionId +
                ", role=" + role +
                ", positionName='" + positionName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

