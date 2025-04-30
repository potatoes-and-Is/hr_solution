package com.poi.hr.domain.approval;

import com.poi.hr.domain.enums.ApprovalDocStatus;
import com.poi.hr.domain.hr.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vacation_reqs")
public class VacationReq extends ApprovalDoc {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vac_type_id", nullable = false)
    private VacationType vacationType;

    @Column(name = "vac_req_start_date", nullable = false)
    private LocalDate vacReqStart;

    @Column(name = "vac_req_end_date", nullable = false)
    private LocalDate vacReqEnd;

    @Column(name = "vac_use_days", nullable = false)
    private double vacUseDay;

    public VacationReq() {
    }

    public VacationReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, VacationType vacationType, LocalDate vacReqStart, LocalDate vacReqEnd, double vacUseDay) {
        super(employee, docType, approvalTitle, approvalContent, approvalReason);
        this.vacationType = vacationType;
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

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    public void setVacReqStart(LocalDate vacReqStart) {
        this.vacReqStart = vacReqStart;
    }

    public void setVacReqEnd(LocalDate vacReqEnd) {
        this.vacReqEnd = vacReqEnd;
    }

    public void setVacUseDay(double vacUseDay) {
        this.vacUseDay = vacUseDay;
    }

    @Override
    public String toString() {
        return "VacationReq{" +
                "vacationType=" + vacationType +
                ", vacReqStart=" + vacReqStart +
                ", vacReqEnd=" + vacReqEnd +
                ", vacUseDay=" + vacUseDay +
                '}';
    }
}