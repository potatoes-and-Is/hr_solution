package com.poi.hr.dto;

import org.springframework.validation.annotation.Validated;

@Validated
public class EmployeeDetailDTO {

    private int employeeId;
    private String empNumber;
    private String name;
    private String gender;
    private String address;
    private String email;
    private String phone;
    private String identity;
    private String status;
    private String hireDate;
    private String retireDate;
    private String deptName;
    private String positionName;
    private String levelName;

    public EmployeeDetailDTO(int employeeId, String empNumber, String name, String gender,
                             String address, String email, String phone, String identity, String status,
                             String hireDate, String retireDate, String deptName, String positionName, String levelName) {
        this.employeeId = employeeId;
        this.empNumber = empNumber;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.identity = identity;
        this.status = status;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.deptName = deptName;
        this.positionName = positionName;
        this.levelName = levelName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
