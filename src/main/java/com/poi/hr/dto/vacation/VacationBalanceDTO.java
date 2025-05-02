package com.poi.hr.dto.vacation;

public class VacationBalanceDTO {

    private Integer vacBalanceId;
    private Double vacCount;
    private Double usedVacCount;
    private Double remainVacCount;
    private Integer year;

    public VacationBalanceDTO(Integer vacBalanceId, Double vacCount, Double usedVacCount, Double remainVacCount, Integer year) {
        this.vacBalanceId = vacBalanceId;
        this.vacCount = vacCount;
        this.usedVacCount = usedVacCount;
        this.remainVacCount = remainVacCount;
        this.year = year;
    }

    public Integer getVacBalanceId() {
        return vacBalanceId;
    }

    public Double getVacCount() {
        return vacCount;
    }

    public Double getUsedVacCount() {
        return usedVacCount;
    }

    public Double getRemainVacCount() {
        return remainVacCount;
    }

    public Integer getYear() {
        return year;
    }
}
