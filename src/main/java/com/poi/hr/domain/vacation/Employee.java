package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_number", nullable = false, unique = true, length = 30)
    private String employeeNumber;

    @Column(name = "employee_name", nullable = false, length = 30)
    private String employeeName;

    @Column(name = "gender", nullable = false, length = 30)
    private String gender;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "employee_identity", nullable = false, length = 50)
    private String employeeIdentity;

    @Column(name = "employee_status", nullable = false, length = 30)
    private String employeeStatus;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "retire_date")
    private LocalDate retireDate; //퇴직일은 null 가능

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;


    public Employee() {

    }

    public Employee(String employeeNumber, String employeeName, String gender, String address, String email, String password, String phone, String employeeIdentity, String employeeStatus, Level level, LocalDate hireDate, LocalDate retireDate) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.employeeStatus = employeeStatus;
        this.level = level;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
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

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
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
                ", levelId=" + (level != null ? level.getLevelId() : null) +
                '}';
    }
}
