package com.poi.hr.dto;


import com.poi.hr.domain.vacation.enums.TeamPositionRole;
import com.poi.hr.domain.vacation.TeamPositionPermission;

import java.util.ArrayList;
import java.util.List;

public class LoginEmployeeDto {

    private int employeeId;
    private String employeeName;
    private String employeeNumber;
    private String password;
    private TeamPositionRole employeeRole;
    private List<TeamPositionPermission> permissions;

    public LoginEmployeeDto() {
    }

    public LoginEmployeeDto(int employeeId, String employeeName, String employeeNumber, String password, TeamPositionRole role, List<TeamPositionPermission> permissions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.password = password;
        this.employeeRole = role;
        this.permissions = permissions;
    }

    public List<String> getRoles() {
        if (this.employeeRole.getRoleName().length() > 0) {
            return List.of(this.employeeRole.getRoleName());
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

    public TeamPositionRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(TeamPositionRole employeeRole) {
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

