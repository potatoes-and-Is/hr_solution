package com.poi.hr.service;

import com.poi.hr.domain.vacation.VacationBalance;
import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import com.poi.hr.repository.vacation.VacationRepository;
import com.poi.hr.repository.vacation.VacationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;
    private final VacationTypeRepository vacationTypeRepository;

    public VacationService(VacationRepository vacationRepository, VacationTypeRepository vacationTypeRepository) {
        this.vacationRepository = vacationRepository;
        this.vacationTypeRepository = vacationTypeRepository;
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

    //휴가신청 - 휴가유형 가져오기
    public List<VacationTypeResDTO> getAllVacationTypes() {

        return vacationTypeRepository.findAll().stream()
                .map(vacationType -> new VacationTypeResDTO(
                        vacationType.getVacTypeId(),
                        vacationType.getVacTypeName()
                ))
                .collect(Collectors.toList());
    }
}
