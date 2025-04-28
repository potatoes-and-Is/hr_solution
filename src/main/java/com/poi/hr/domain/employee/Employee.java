package com.poi.hr.domain.employee;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_number")
    private String employeeNumber;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "employee_identity")
    private String employeeIdentity;

    @Column(name = "employee_status")
    private String employeeStatus;

    @CreationTimestamp
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "retire_date")
    private LocalDate retireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    @Transient
    private Integer deptId;

    @Transient
    private Integer positionId;

    @Transient
    private String deptName;

    @Transient
    private String positionName;

    @Transient
    private String levelName;

    @Transient
    private Integer levelId;


    public Employee(){

    }

    public Employee(int employeeId, String employeeNumber, String employeeName, String gender, String address, String email, String password, String phone, String employeeIdentity, String employeeStatus, LocalDate hireDate, LocalDate retireDate, Level level, Integer deptId, Integer positionId, String deptName, String positionName, String levelName) {
        this.employeeId = employeeId;
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.employeeStatus = employeeStatus;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.level = level;
        this.deptId = deptId;
        this.positionId = positionId;
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

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String empNumber) {
        this.employeeNumber = empNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
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

    public void setEmployeeIdentity(String identity) {
        this.employeeIdentity = identity;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String status) {
        this.employeeStatus = status;
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

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeIdentity='" + employeeIdentity + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", hireDate=" + hireDate +
                ", retireDate=" + retireDate +
                ", level=" + level +
                ", deptId=" + deptId +
                ", positionId=" + positionId +
                ", deptName='" + deptName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", levelName='" + levelName + '\'' +
                ", levelId=" + levelId +
                '}';
    }
}
