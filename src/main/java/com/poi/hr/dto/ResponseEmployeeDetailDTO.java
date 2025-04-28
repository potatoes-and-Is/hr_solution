package com.poi.hr.dto;

import org.springframework.validation.annotation.Validated;

@Validated
public class ResponseEmployeeDetailDTO {

    private int employeeId;
    private String employeeNumber;
    private String employeeName;
    private String gender;
    private String address;
    private String email;
    private String phone;
    private String employeeIdentity;
    private String status;
    private String hireDate;
    private String retireDate;
    private String deptName;
    private String positionName;
    private String levelName;

    public ResponseEmployeeDetailDTO(int employeeId, String employeeNumber, String employeeName, String gender,
                                     String address, String email, String phone, String employeeIdentity, String status,
                                     String hireDate, String retireDate, String deptName, String positionName, String levelName) {
        this.employeeId = employeeId;
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.status = status;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.deptName = deptName;
        this.positionName = positionName;
        this.levelName = levelName;
    }

    public ResponseEmployeeDetailDTO(String employeeName, String deptName, String positionName, String phone, String email) {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmployeeIdentity() {
        return employeeIdentity;
    }

    public void setEmployeeIdentity(String employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(String retireDate) {
        this.retireDate = retireDate;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
