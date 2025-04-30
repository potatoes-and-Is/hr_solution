package com.poi.hr.dto;

public class UpdateEmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private String address;
    private String employeeIdentity;
    private String password;
    private String status;
    private String gender;
    private Integer levelId;
    private Integer deptId;
    private Integer positionId;

    public UpdateEmployeeDTO() {}

    public UpdateEmployeeDTO(int employeeId, String employeeName, String email, String phone, String address,
                             String employeeIdentity, String password, String status,
                             String gender, Integer levelId, Integer deptId, Integer positionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeIdentity = employeeIdentity;
        this.password = password;
        this.status = status;
        this.gender = gender;
        this.levelId = levelId;
        this.deptId = deptId;
        this.positionId = positionId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
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
}


