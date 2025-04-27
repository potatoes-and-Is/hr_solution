package com.poi.hr.domain.hr;

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
    private String positionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    public TeamPosition() {
    }

    public int getTeamPositionId() {
        return teamPositionId;
    }

    public void setTeamPositionId(int teamPositionId) {
        this.teamPositionId = teamPositionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TeamPosition{" +
                "teamPositionId=" + teamPositionId +
                ", positionName='" + positionName + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                '}';
    }
}