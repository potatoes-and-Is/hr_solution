package com.poi.hr.dto.vacation;

/* 나의 휴가 - 상세리스트 출력 위한 데이터 */
public class MyVacationListDTO {

    private Long id; //지급 ID or 휴가신청 ID
    private String division; //'지급' 혹은 '차감'
    private String vacationType;
    private String startDate;
    private String endDate;
    private double days;
    private String approvalStatus;

    public MyVacationListDTO() {

    }

    public MyVacationListDTO(Long id, String division, String vacationType, String startDate, String endDate, double days, String approvalStatus) {
        this.id = id;
        this.division = division;
        this.vacationType = vacationType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.approvalStatus = approvalStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "MyVacationListDTO{" +
                "id=" + id +
                ", division='" + division + '\'' +
                ", vacationType='" + vacationType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", days=" + days +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
