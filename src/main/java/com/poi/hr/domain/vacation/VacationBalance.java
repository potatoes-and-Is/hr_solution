package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

@Entity
@Table(name = "Vacation_balances",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "uq_employee_vacation",
                    columnNames = {"employee_id", "vac_type_id"}
            )
        }
)
public class VacationBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vac_balance_id")
    private int vacBalanceId;

    @Column(name = "vac_count", nullable = false)
    private Double vacCount;

    @Column(name = "used_vac_count", nullable = false)
    private Double usedVacCount;

    @Column(name = "remain_vac_count", nullable = false)
    private Double remainVacCount;

    @Column(name = "year")
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vac_type_id")
    private VacationType vacationType;

    public VacationBalance() {

    }

    public VacationBalance(Double vacCount, Double usedVacCount, Double remainVacCount, Integer year, Employee employee, VacationType vacationType) {
        this.vacCount = vacCount;
        this.usedVacCount = usedVacCount;
        this.remainVacCount = remainVacCount;
        this.year = year;
        this.employee = employee;
        this.vacationType = vacationType;
    }

    public int getVacBalanceId() {
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

    public Employee getEmployee() {
        return employee;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacCount(Double vacCount) {
        this.vacCount = vacCount;
    }

    public void setUsedVacCount(Double usedVacCount) {
        this.usedVacCount = usedVacCount;
    }

    public void setRemainVacCount(Double remainVacCount) {
        this.remainVacCount = remainVacCount;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    @Override
    public String toString() {
        return "VacationBalance{" +
                "vacBalanceId=" + vacBalanceId +
                ", vacCount=" + vacCount +
                ", usedVacCount=" + usedVacCount +
                ", remainVacCount=" + remainVacCount +
                ", year=" + year +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", vacationTypeId=" + (vacationType != null ? vacationType.getVacTypeId() : null) +
                '}';
    }
}
