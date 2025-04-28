package com.poi.hr.domain.attendance;

import com.poi.hr.domain.employee.Employee;
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
    private LocalDateTime attendDate;

    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Column(name = "check_in_status")
    private char checkInStatus;

    @Column(name = "check_out_status")
    private char checkOutStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "attend_status")
    private AttendStatus attendStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
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

    public int getAttendId() {
        return attendId;
    }

    public LocalDate getAttendDate() {
        return attendDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public LocalTime getCheckOutTime() {
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
                ", employee=" + employee +
                '}';
    }
}
