package com.poi.hr.dto;

import com.poi.hr.domain.attendance.AttendStatus;
import com.poi.hr.domain.employee.Employee;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendDTO {

    private Integer attendId;

    private LocalDate attendDate;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private char checkInStatus;

    private char checkOutStatus;

    private AttendStatus attendStatus;

    private Employee employee;


    public AttendDTO() {}

    public AttendDTO(Integer attendId, LocalDate attendDate, LocalTime checkInTime, LocalTime checkOutTime, char checkInStatus, char checkOutStatus, AttendStatus attendStatus, Employee employee) {
        this.attendId = attendId;
        this.attendDate = attendDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.checkInStatus = checkInStatus;
        this.checkOutStatus = checkOutStatus;
        this.attendStatus = attendStatus;
        this.employee = employee;
    }

    // attendList 를 위한 생성자
    public AttendDTO(int attendId, LocalDate attendDate, LocalTime checkInTime, LocalTime checkOutTime, AttendStatus attendStatus) {
        this.attendId = attendId;
        this.attendDate = attendDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.attendStatus = attendStatus;
    }

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
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
}
