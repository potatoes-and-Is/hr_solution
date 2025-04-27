package com.poi.hr.service;

import org.springframework.stereotype.Service;

@Service
public class VacationService {
    //대시보드 - 총 부여된 휴가 가져오기
    public int getTotalVacationDays(int employeeId) {

        return 15; //테스트
    }

    //대시보드 - 사용한 휴가 가져오기
    public int getUsedVacationDays(int employeeId) {

        return 5; //테스트
    }

    //대시보드 - 사용 가능한 휴가 가져오기
    public int getRemainingVacationDays(int employeeId) {

        return getTotalVacationDays(employeeId) - getUsedVacationDays(employeeId);
    }


}
