package com.poi.hr.domain.vacation;

import com.poi.hr.domain.hr.TeamPosition;
import jakarta.persistence.*;

@Entity
@Table(name = "Team_position_permissions")
public class TeamPositionPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_position_permission_id")
    private int teampositionPermissionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ui_permission_id")
    private UiPermission uiPermission;

    public int getTeamPositionPermissionId() {
        return teampositionPermissionId;
    }

    public TeamPosition getTeamPosition() {
        return teamPosition;
    }

    public UiPermission getUiPermission() {
        return uiPermission;
    }

    public void setTeamPosition(TeamPosition teamPosition) {
        this.teamPosition = teamPosition;
    }

    public void setUiPermission(UiPermission uiPermission) {
        this.uiPermission = uiPermission;
    }

    @Override
    public String toString() {
        return "TeamPositionPermission{" +
                "teampositionPermissionId=" + teampositionPermissionId +
                ", teamPosition=" + (teamPosition != null ? teamPosition.getTeamPositionId() : null) +
                ", uiPermission=" + (uiPermission != null ? uiPermission.getUiPermissionId() : null) +
                '}';
    }
}
