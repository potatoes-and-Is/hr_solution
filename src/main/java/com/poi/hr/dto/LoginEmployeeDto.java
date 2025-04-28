package com.poi.hr.dto;


import com.poi.hr.domain.common.Role;
import com.poi.hr.domain.login.entity.TeamPositionPermission;

import java.util.ArrayList;
import java.util.List;

public class LoginEmployeeDto {

    private int employeeId;
    private String employeeName;
    private String employeeNumber;
    private String password;
    private Role employeeRole;
    private List<TeamPositionPermission> permissions;

    public LoginEmployeeDto() {
    }

    public LoginEmployeeDto(int employeeId, String employeeName, String employeeNumber, String password, Role role, List<TeamPositionPermission> permissions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.password = password;
        this.employeeRole = role;
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        if (this.employeeRole.getRole().length() > 0) {
            return List.of(this.employeeRole.getRole());
        }
        return new ArrayList<>();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Role employeeRole) {
        this.employeeRole = employeeRole;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<TeamPositionPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<TeamPositionPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "LoginEmployeeDto{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", password='" + password + '\'' +
                ", employeeRole=" + employeeRole +
                '}';
    }
}

