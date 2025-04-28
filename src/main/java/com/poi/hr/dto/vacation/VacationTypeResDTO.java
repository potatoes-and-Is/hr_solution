package com.poi.hr.dto.vacation;

public class VacationTypeResDTO {

    private int vacTypeId;
    private String vacTypeName;

    public VacationTypeResDTO(int vacTypeId, String vacTypeName) {
        this.vacTypeId = vacTypeId;
        this.vacTypeName = vacTypeName;
    }

    public int getVacTypeId() {
        return vacTypeId;
    }

    public String getVacTypeName() {
        return vacTypeName;
    }
}
