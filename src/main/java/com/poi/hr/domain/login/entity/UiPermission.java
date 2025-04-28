package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ui_permissions")
public class UiPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ui_permission_id", nullable = false)
    private int uiPermissionId;

    @Column(name = "permission_role", nullable = false)
    private String permissionRole;

    @Column(name = "permission_name", nullable = false)
    private String permissionName;

    public UiPermission() {
    }

    public UiPermission(String permissionRole, String permissionName) {
        this.permissionRole = permissionRole;
        this.permissionName = permissionName;
    }

    public int getUiPermissionId() {
        return uiPermissionId;
    }

    public String getPermissionRole() {
        return permissionRole;
    }

    public String getPermissionName() {
        return permissionName;
    }

    @Override
    public String toString() {
        return "UiPermission{" +
                "uiPermissionId=" + uiPermissionId +
                ", permissionRole='" + permissionRole + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
