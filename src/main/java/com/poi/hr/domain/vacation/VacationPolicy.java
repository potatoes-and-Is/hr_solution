package com.poi.hr.domain.vacation;

import jakarta.persistence.*;
import org.codehaus.groovy.classgen.asm.util.LoggableClassVisitor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Vacation_policies")
public class VacationPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private int policyId;

    @Column(name = "level_id", nullable = false)
    private int levelId;

    @Column(name = "vacation_type", nullable = false, length = 20)
    private String vacationType;

    @Column(name = "days_per_year")
    private int daysPerYear;

    @Column(name = "policy_cycle", nullable = false, length = 20)
    private String policyCycle;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public VacationPolicy() {

    }

    public VacationPolicy(int levelId, String vacationType, int daysPerYear, String policyCycle) {
        this.levelId = levelId;
        this.vacationType = vacationType;
        this.daysPerYear = daysPerYear;
        this.policyCycle = policyCycle;
    }

    public int getPolicyId() {
        return policyId;
    }

    public int getLevelId() {
        return levelId;
    }

    public String getVacationType() {
        return vacationType;
    }

    public int getDaysPerYear() {
        return daysPerYear;
    }

    public String getPolicyCycle() {
        return policyCycle;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public void setDaysPerYear(int daysPerYear) {
        this.daysPerYear = daysPerYear;
    }

    public void setPolicyCycle(String policyCycle) {
        this.policyCycle = policyCycle;
    }

    @Override
    public String toString() {
        return "VacationPolicy{" +
                "policyId=" + policyId +
                ", levelId=" + levelId +
                ", vacationType='" + vacationType + '\'' +
                ", daysPerYear=" + daysPerYear +
                ", policyCycle='" + policyCycle + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}