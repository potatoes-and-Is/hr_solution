package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

@Entity
@Table(name = "Ui_permissions")
public class UiPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ui_permission_id")
    private int uiPermissionId;

    @Column(name = "permission_role", nullable = false, length = 255)
    private String permissionRole;

    @Column(name = "permission_name", nullable = false, length = 50)
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

    public void setPermissionRole(String permissionRole) {
        this.permissionRole = permissionRole;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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
