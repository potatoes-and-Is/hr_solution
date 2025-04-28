package com.poi.hr.dto;

import java.time.LocalTime;

public class CheckOutDTO {

    private LocalTime checkOutTime = LocalTime.now();

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
