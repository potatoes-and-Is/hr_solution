package com.poi.hr.dto.vacation;

public class VacationBalanceDTO {

    private Integer vacBalanceId;
    private int vacCount;
    private int usedVacCount;
    private int remainVacCount;
    private Integer year;

    public VacationBalanceDTO(Integer vacBalanceId, int vacCount, int usedVacCount, int remainVacCount, Integer year) {
        this.vacBalanceId = vacBalanceId;
        this.vacCount = vacCount;
        this.usedVacCount = usedVacCount;
        this.remainVacCount = remainVacCount;
        this.year = year;
    }

    public Integer getVacBalanceId() {
        return vacBalanceId;
    }

    public int getVacCount() {
        return vacCount;
    }

    public int getUsedVacCount() {
        return usedVacCount;
    }

    public int getRemainVacCount() {
        return remainVacCount;
    }

    public Integer getYear() {
        return year;
    }
}
