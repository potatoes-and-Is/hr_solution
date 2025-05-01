package com.poi.hr.domain.employee;

import com.poi.hr.domain.dept.DepPositionEmployee;
import com.poi.hr.domain.hr.Level;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name", nullable = false, length = 30)
    private String employeeName;

    @Column(name = "gender", nullable = false, length = 30)
    private String gender;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
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
    private LocalDate retireDate;

    @Column(name = "employee_number", nullable = false, unique = true, length = 30)
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

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmployeeIdentity(String employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepPositionEmployees(List<DepPositionEmployee> depPositionEmployees) {
        this.depPositionEmployees = depPositionEmployees;
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
                ", depPositionEmployees=" + (depPositionEmployees != null ? depPositionEmployees.getClass() : null) +
                '}';
    }
}