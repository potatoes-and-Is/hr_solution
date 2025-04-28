package com.poi.hr.domain.vacation;

import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Team_positions")
public class TeamPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamPositionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private TeamPositionRole role;

    @Column(name = "position_name", nullable = false, length = 30)
    private String positionName;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public TeamPosition() {

    }

    public TeamPosition(TeamPositionRole role, String positionName) {
        this.role = role;
        this.positionName = positionName;
    }

    public int getTeamPositionId() {
        return teamPositionId;
    }

    public TeamPositionRole getRole() {
        return role;
    }

    public String getPositionName() {
        return positionName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setRole(TeamPositionRole role) {
        this.role = role;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "TeamPosition{" +
                "teamPositionId=" + teamPositionId +
                ", role=" + role +
                ", positionName='" + positionName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}