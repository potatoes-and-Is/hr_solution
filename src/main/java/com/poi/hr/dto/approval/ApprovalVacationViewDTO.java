package com.poi.hr.dto.approval;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.vacation.VacationType;

import java.util.List;

public class ApprovalVacationViewDTO {
    private List<VacationType> vacTypeList;
    private final List<Dept> deptList;

    public ApprovalVacationViewDTO(List<Dept> deptList, List<VacationType> vacTypeList) {
        this.deptList = deptList;
        this.vacTypeList = vacTypeList;
    }

    public List<VacationType> getVacTypeList() {
        return vacTypeList;
    }

    public void setVacTypeList(List<VacationType> vacTypeList) {
        this.vacTypeList = vacTypeList;
    }
}
