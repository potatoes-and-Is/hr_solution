package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "team_position_permissions")
public class TeamPositionPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_position_permission_id", nullable = false)
    private int teamPositionPermissionId;

    @ManyToOne
    @JoinColumn(name = "team_position_id")
    private TeamPosition teamPosition;

    @ManyToOne
    @JoinColumn(name = "ui_permission_id")
    private UiPermission uiPermission;


}
