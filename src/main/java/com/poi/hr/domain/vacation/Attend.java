package com.poi.hr.domain.vacation;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.enums.AttendStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Attends")
public class Attend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attend_id")
    private int attendId;

    @Column(name = "attend_date", nullable = false)
    private LocalDate attendDate;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "check_in_status", nullable = false)
    private char checkInStatus = 'N';

    @Column(name = "check_out_status", nullable = false)
    private char checkOutStatus = 'N';

    @Enumerated(EnumType.STRING)
    @Column(name = "attend_status")
    private AttendStatus attendStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Attend() {

    }

    public Attend(char checkInStatus, char checkOutStatus, AttendStatus attendStatus, Employee employee) {
        this.checkInStatus = checkInStatus;
        this.checkOutStatus = checkOutStatus;
        this.attendStatus = attendStatus;
        this.employee = employee;
    }

    public int getAttendId() {
        return attendId;
    }

    public LocalDate getAttendDate() {
        return attendDate;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public char getCheckInStatus() {
        return checkInStatus;
    }

    public char getCheckOutStatus() {
        return checkOutStatus;
    }

    public AttendStatus getAttendStatus() {
        return attendStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setAttendDate(LocalDate attendDate) {
        this.attendDate = attendDate;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setCheckInStatus(char checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public void setCheckOutStatus(char checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }

    public void setAttendStatus(AttendStatus attendStatus) {
        this.attendStatus = attendStatus;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Attend{" +
                "attendId=" + attendId +
                ", attendDate=" + attendDate +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", checkInStatus=" + checkInStatus +
                ", checkOutStatus=" + checkOutStatus +
                ", attendStatus=" + attendStatus +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                '}';
    }
}