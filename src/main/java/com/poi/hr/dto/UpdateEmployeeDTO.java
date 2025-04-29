package com.poi.hr.dto;

import com.poi.hr.domain.employee.Employee;

public class UpdateEmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private String address;
    private String employeeIdentity;
    private String password;
    private String employeeStatus;

    public UpdateEmployeeDTO() {

    }

    public UpdateEmployeeDTO(int employeeId, String employeeName, String email, String phone, String address, String employeeIdentity, String password, String employeeStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeIdentity = employeeIdentity;
        this.password = password;
        this.employeeStatus = employeeStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeIdentity() {
        return employeeIdentity;
    }

    public void setEmployeeIdentity(String employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}

