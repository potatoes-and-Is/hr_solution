package com.poi.hr.dto.vacation;

import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.vacation.VacationType;
import com.poi.hr.domain.vacation.enums.LeaveType;

import java.util.List;

public class VacationViewDTO {

    private final List<VacationType> vacationTypeList;
    private final List<Dept> deptList;

    public VacationViewDTO(List<VacationType> vacationTypeList, List<Dept> deptList) {
        this.vacationTypeList = vacationTypeList;
        this.deptList = deptList;
    }

    public List<VacationType> getVacationTypeList() {
        return vacationTypeList;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }
}
