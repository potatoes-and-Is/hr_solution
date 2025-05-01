package com.poi.hr.domain.hr;

import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import com.poi.hr.domain.vacation.TeamPositionPermission;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team_positions")
public class TeamPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_position_id")
    private int teamPositionId;

    @Column(name = "position_name", nullable = false, length = 30)
    private String positionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private TeamPositionRole role;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDate createdAt;

    @OneToMany(mappedBy = "teamPosition", fetch = FetchType.LAZY)
    private List<TeamPositionPermission> permissions = new ArrayList<>();

    public TeamPosition() {
    }

    public TeamPosition(String positionName, TeamPositionRole role) {
        this.positionName = positionName;
        this.role = role;
    }

    public int getTeamPositionId() {
        return teamPositionId;
    }

    public String getPositionName() {
        return positionName;
    }


    public TeamPositionRole getRole() {
        return role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<TeamPositionPermission> getPermissions() {
        return permissions;
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