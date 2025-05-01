package com.poi.hr.dto.vacation;

import java.time.LocalDate;

public class DepartmentVacationDto {
    private String employeeName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String vacationType;

    public DepartmentVacationDto(String employeeName, LocalDate startDate, LocalDate endDate, String vacationType) {
        this.employeeName = employeeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vacationType = vacationType;
    }

    // Getters
    public String getEmployeeName() { return employeeName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getVacationType() { return vacationType; }
}