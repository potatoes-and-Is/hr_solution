package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Vacation_types")
public class VacationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vac_type_id", nullable = false)
    private int vacTypeId;

    @Column(name = "vac_type_code", nullable = false, length = 30)
    private String vacTypeCode;

    @Column(name = "vac_type_name", nullable = false, length = 50)
    private String vacTypeName;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid = true; //DB에 Default True 있지만, JPA가 명시적으로 null을 보내면 DB 디폴트 적용 안 됨

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public VacationType() {
    }

    public VacationType(String vacTypeCode, String vacTypeName, boolean isPaid) {
        this.vacTypeCode = vacTypeCode;
        this.vacTypeName = vacTypeName;
        this.isPaid = isPaid;
    }

    public int getVacTypeId() {
        return vacTypeId;
    }

    public String getVacTypeCode() {
        return vacTypeCode;
    }

    public String getVacTypeName() {
        return vacTypeName;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setVacTypeCode(String vacTypeCode) {
        this.vacTypeCode = vacTypeCode;
    }

    public void setVacTypeName(String vacTypeName) {
        this.vacTypeName = vacTypeName;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return "VacationType{" +
                "vacTypeId=" + vacTypeId +
                ", vacTypeCode='" + vacTypeCode + '\'' +
                ", vacTypeName='" + vacTypeName + '\'' +
                ", isPaid=" + isPaid +
                ", createdAt=" + createdAt +
                '}';
    }
}
