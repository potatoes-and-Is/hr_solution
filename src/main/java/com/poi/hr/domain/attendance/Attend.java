package com.poi.hr.domain.attendance;

import com.poi.hr.domain.login.entity.Employee;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Column(name = "check_in_status", length = 1)
    private char checkInStatus = 'N';

    @Column(name = "check_out_status", length = 1)
    private char checkOutStatus = 'N';

    @Enumerated(EnumType.STRING)
    @Column(name = "attend_status", nullable = false)
    private AttendStatus attendStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public Attend() {}

    public Attend(LocalDate attendDate, LocalTime checkInTime, LocalTime checkOutTime, char checkInStatus, char checkOutStatus, AttendStatus attendStatus, Employee employee) {
        this.attendDate = attendDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.checkInStatus = checkInStatus;
        this.checkOutStatus = checkOutStatus;
        this.attendStatus = attendStatus;
        this.employee = employee;
    }

    public Attend(LocalDate attendDate, LocalTime checkInTime, char checkInStatus, AttendStatus attendStatus, Employee employee) {
        this.attendDate = attendDate;
        this.checkInTime = checkInTime;
        this.checkInStatus = checkInStatus;
        this.attendStatus = attendStatus;
        this.employee = employee;
    }

    public int getAttendId() {
        return attendId;
    }

    public void setAttendId(int attendId) {
        this.attendId = attendId;
    }

    public LocalDate getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(LocalDate attendDate) {
        this.attendDate = attendDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public char getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(char checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public char getCheckOutStatus() {
        return checkOutStatus;
    }

    public void setCheckOutStatus(char checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }

    public AttendStatus getAttendStatus() {
        return attendStatus;
    }

    public void setAttendStatus(AttendStatus attendStatus) {
        this.attendStatus = attendStatus;
    }

    public Employee getEmployee() {
        return employee;
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