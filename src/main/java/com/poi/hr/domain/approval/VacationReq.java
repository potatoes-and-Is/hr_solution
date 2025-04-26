package com.poi.hr.domain.approval;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "vacation_reqs")
public class VacationReq extends ApprovalDocs{

    private LocalDate vacReqStart;
    private LocalDate vacReqEnd;
    private double vacUseDay;

    public VacationReq() {
    }

    public VacationReq(LocalDate vacReqStart, LocalDate vacReqEnd, double vacUseDay) {
        this.vacReqStart = vacReqStart;
        this.vacReqEnd = vacReqEnd;
        this.vacUseDay = vacUseDay;
    }

    public LocalDate getVacReqStart() {
        return vacReqStart;
    }

    public LocalDate getVacReqEnd() {
        return vacReqEnd;
    }

    public double getVacUseDay() {
        return vacUseDay;
    }
}