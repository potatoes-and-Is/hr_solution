package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false)
    private int employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "employee_identity", nullable = false)
    private String employeeIdentity;

    @Column(name = "employee_status", nullable = false)
    private String employeeStatus;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @Column(name = "retire_date", nullable = false)
    private LocalDate retireDate;

    @Column(name = "employee_number", nullable = false)
    private String employeeNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<DepPositionEmployee> depPositionEmployees;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String gender, String email, String password, String phone, String employeeIdentity, String employeeStatus, LocalDate hireDate, LocalDate retireDate, String employeeNumber, Level level, List<DepPositionEmployee> depPositionEmployees) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.employeeStatus = employeeStatus;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.employeeNumber = employeeNumber;
        this.level = level;
        this.depPositionEmployees = depPositionEmployees;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmployeeIdentity() {
        return employeeIdentity;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public Level getLevel() {
        return level;
    }

    public List<DepPositionEmployee> getDepPositionEmployees() {
        return depPositionEmployees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeIdentity='" + employeeIdentity + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", hireDate=" + hireDate +
                ", retireDate=" + retireDate +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", level=" + level +
                ", depPositionEmployees=" + depPositionEmployees +
                '}';
    }
}
