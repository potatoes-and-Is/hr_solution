package com.poi.hr.dto;

import java.time.LocalTime;

public class CheckInDTO {

    private LocalTime checkInTime;

    public CheckInDTO() {}

    public CheckInDTO(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
