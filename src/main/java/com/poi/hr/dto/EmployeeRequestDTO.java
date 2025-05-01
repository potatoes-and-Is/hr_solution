package com.poi.hr.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poi.hr.domain.hr.Level;

import java.time.LocalDate;
import java.util.List;

public class EmployeeRequestDTO {
    private int employeeId;

    private String employeeNumber;

    private String employeeName;

    private String gender;

    private String address;

    private String email;

    private String password;

    private String phone;

    private String employeeIdentity;

    private String employeeStatus;

    private LocalDate hireDate;

    private LocalDate retireDate;

    private Level level;

    private Integer deptId;

    private Integer positionId;

    private String deptName;

    private String positionName;

    private String levelName;

    private Integer levelId;

    // 추가된 필드: 경력, 학력, 자격증, 어학
    private List<CareerDTO> careers;
    private List<EducationDTO> educations;
    private List<QualificationDTO> qualifications;
    private List<LanguageDTO> languages;

    // 기존 getter, setter들...


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeIdentity() {
        return employeeIdentity;
    }

    public void setEmployeeIdentity(String employeeIdentity) {
        this.employeeIdentity = employeeIdentity;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
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

    // 기본 생성자 및 파라미터 생성자 (기존 코드 그대로 유지)

    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(
            int employeeId,
            String employeeNumber,
            String employeeName,
            String gender,
            String address,
            String email,
            String password,
            String phone,
            String employeeIdentity,
            String employeeStatus,
            LocalDate hireDate,
            LocalDate retireDate,
            Integer deptId,
            Integer positionId,
            String deptName,
            String positionName,
            Integer levelId,
            String levelName
    ) {
        this.employeeId = employeeId;
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.employeeIdentity = employeeIdentity;
        this.employeeStatus = employeeStatus;
        this.hireDate = hireDate;
        this.retireDate = retireDate;
        this.deptId = deptId;
        this.positionId = positionId;
        this.deptName = deptName;
        this.positionName = positionName;
        this.levelId = levelId;
        this.levelName = levelName;
    }

}

