package com.poi.hr.dto;

import java.time.LocalTime;

public class CheckInDTO {

    private LocalTime checkInTime = LocalTime.now();

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
