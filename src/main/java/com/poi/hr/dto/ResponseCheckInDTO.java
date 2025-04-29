package com.poi.hr.dto;

import java.time.LocalTime;

public class ResponseCheckInDTO {

    private int employeeId;
    private LocalTime checkInTime;
    private char attendStatus;

    public ResponseCheckInDTO(int employeeId, LocalTime checkInTime, char attendStatus) {
        this.employeeId = employeeId;
        this.checkInTime = checkInTime;
        this.attendStatus = attendStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public char getAttendStatus() {
        return attendStatus;
    }
}
