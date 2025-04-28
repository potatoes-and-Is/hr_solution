package com.poi.hr.domain.vacation;

import com.poi.hr.domain.login.entity.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Vacation_reqs")
public class VacationReq extends ApprovalDoc {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vac_type_id", nullable = false)
    private VacationType vacationType;

    @Column(name = "vac_req_start_date", nullable = false)
    private LocalDate vacReqStartDate;

    @Column(name = "vac_req_end_date", nullable = false)
    private LocalDate vacReqEndDate;

    @Column(name = "vac_use_days", nullable = false)
    private int vacUseDays;

    public VacationReq() {

    }

    public VacationReq(Employee employee, DocType docType, String approvalTitle, String approvalContent, String approvalReason, VacationType vacationType, LocalDate vacReqStartDate, LocalDate vacReqEndDate, int vacUseDays) {
        super(employee, docType, approvalTitle, approvalContent, approvalReason);
        this.vacationType = vacationType;
        this.vacReqStartDate = vacReqStartDate;
        this.vacReqEndDate = vacReqEndDate;
        this.vacUseDays = vacUseDays;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public LocalDate getVacReqStartDate() {
        return vacReqStartDate;
    }

    public LocalDate getVacReqEndDate() {
        return vacReqEndDate;
    }

    public int getVacUseDays() {
        return vacUseDays;
    }

    public void setVacReqStartDate(LocalDate vacReqStartDate) {
        this.vacReqStartDate = vacReqStartDate;
    }

    public void setVacReqEndDate(LocalDate vacReqEndDate) {
        this.vacReqEndDate = vacReqEndDate;
    }

    public void setVacUseDays(int vacUseDays) {
        this.vacUseDays = vacUseDays;
    }

    @Override
    public String toString() {
        return "VacationReq{" +
                "vacationTypeId=" + (vacationType != null ? vacationType.getVacTypeId() : null) +
                ", vacReqStartDate=" + vacReqStartDate +
                ", vacReqEndDate=" + vacReqEndDate +
                ", vacUseDays=" + vacUseDays +
                '}';
    }
}