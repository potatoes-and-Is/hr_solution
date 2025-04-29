package com.poi.hr.service;

import com.poi.hr.domain.vacation.VacationBalance;
import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.repository.VacationRepository;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    //대시보드 - 휴가정보 가져오기
    public VacationBalanceDTO getTotalVacationInfo(int employeeId) {
        VacationBalance vacationBalance = vacationRepository.findByEmployee_EmployeeId(employeeId);

        if (vacationBalance == null) {
            return new VacationBalanceDTO(0, 0, 0, 0, 2025);
        }

        return new VacationBalanceDTO(
                vacationBalance.getVacBalanceId(),
                vacationBalance.getVacCount(),
                vacationBalance.getUsedVacCount(),
                vacationBalance.getRemainVacCount(),
                vacationBalance.getYear()
        );
    }
}
