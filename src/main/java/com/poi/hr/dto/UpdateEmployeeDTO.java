package com.poi.hr.dto;

import java.util.List;

public class UpdateEmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private String address;
    private String employeeIdentity;
    private String password;
    private String employeeStatus;
    private String gender;

    private List<CareerDTO> careers;         // 경력 리스트
    private List<EducationDTO> educations;   // 학력 리스트
    private List<QualificationDTO> qualifications;  // 자격증 리스트
    private List<LanguageDTO> languages;     // 어학 리스트


    private Integer levelId;
    private Integer deptId;
    private Integer positionId;

    public UpdateEmployeeDTO() {
    }

    public UpdateEmployeeDTO(int employeeId, String employeeName, String email, String phone, String address, String employeeIdentity, String password, String employeeStatus, String gender, List<CareerDTO> careers, List<EducationDTO> educations, List<QualificationDTO> qualifications, List<LanguageDTO> languages, Integer levelId, Integer deptId, Integer positionId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeIdentity = employeeIdentity;
        this.password = password;
        this.employeeStatus = employeeStatus;
        this.gender = gender;
        this.careers = careers;
        this.educations = educations;
        this.qualifications = qualifications;
        this.languages = languages;
        this.levelId = levelId;
        this.deptId = deptId;
        this.positionId = positionId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeIdentity() {
        return employeeIdentity;
    }

    public void setEmployeeIdentity(String employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<CareerDTO> getCareers() {
        return careers;
    }

    public void setCareers(List<CareerDTO> careers) {
        this.careers = careers;
    }

    public List<EducationDTO> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationDTO> educations) {
        this.educations = educations;
    }

    public List<QualificationDTO> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<QualificationDTO> qualifications) {
        this.qualifications = qualifications;
    }

    public List<LanguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageDTO> languages) {
        this.languages = languages;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
}


