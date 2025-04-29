package com.poi.hr.dto;

import com.poi.hr.domain.hr.Level;

import java.time.LocalDate;

public class EmployeeRequestDTO {
    private int employeeId;

    private String employeeNumber;

    private String employeeName;

    private String gender;

    private String address;

    private String email;

    private String password;

    private String phone;

    private String employeeIdentity;

    private String status;

    private LocalDate hireDate;

    private LocalDate retireDate;

    private Level level;

    private Integer deptId;

    private Integer positionId;

    private String deptName;

    private String positionName;

    private String levelName;

    private Integer levelId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
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

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(
            int employeeId,
            String employeeNumber,
            String employeeName,
            String gender,
            String address,
            String email,
            String password,
            String phone,
            String employeeIdentity,
            String status,
            LocalDate hireDate,
            LocalDate retireDate,
            Integer deptId,
            Integer positionId,
            String deptName,
            String positionName,
            Integer levelId,
            String levelName
    ) {
        this.employeeId = employeeId;
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.status = status;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.deptId = deptId;
        this.positionId = positionId;
        this.deptName = deptName;
        this.positionName = positionName;
        this.levelName = levelName;
        this.levelId = levelId;
    }
}
