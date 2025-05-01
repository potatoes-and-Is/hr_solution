package com.poi.hr.dto;

import java.time.LocalTime;

public class CheckOutDTO {

    public CheckOutDTO() {
    }

    private LocalTime checkOutTime = LocalTime.now();

    public CheckOutDTO(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public LocalTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
