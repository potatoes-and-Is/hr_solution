package com.poi.hr.domain.login.entity;

import com.poi.hr.domain.common.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "team_positions")
public class TeamPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_position_id", nullable = false)
    private int teamPositionId;

    @Column(name = "position_name", nullable = false)
    private String PositionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    public TeamPosition() {
    }

    public TeamPosition(String positionName, Role role) {
        PositionName = positionName;
        this.role = role;
    }

    public int getTeamPositionId() {
        return teamPositionId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "TeamPositions{" +
                "teamPositionId=" + teamPositionId +
                ", PositionName='" + PositionName + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}
