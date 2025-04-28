package com.poi.hr.service;

import com.poi.hr.domain.vacation.VacationBalance;
import com.poi.hr.dto.vacation.MyVacationListDTO;
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
    public VacationBalanceDTO getTotalVacationInfo(int employeeId, int year) {
        VacationBalance vacationBalance = vacationRepository.findByEmployee_EmployeeIdAndYear(employeeId, year);

        if (vacationBalance == null) {
            return new VacationBalanceDTO(0, 0.0, 0.0, 0.0, 2025);
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


    //휴가 리스트 출력 시 해당 회원 데이터 있는 연도들을 반환
    public List<Integer> getAvailableYears(int employeeId) {
        return vacationRepository.findAvailableYearsByEmployeeId(employeeId);
    }

    //휴가 리스트 가져오기
    public List<MyVacationListDTO> getMyVacationList(int employeeId, int year) {
        // 1. 지급(+) 내역 조회 (vacation_grant_histories 테이블)
        // 2. 차감(-) 내역 조회 (vacation_reqs 테이블, 승인된 것만)
        // 3. 둘 다 합쳐서 DTO로 변환
        // 4. return

        // 일단 계획만 세웠음 추가구현필요!!
        return null;
    }


}
