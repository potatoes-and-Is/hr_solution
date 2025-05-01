package com.poi.hr.service;

import com.poi.hr.domain.employee.Employee;
import com.poi.hr.domain.vacation.*;
import com.poi.hr.dto.approval.ApprovalEmpLeaveSaveDto;
import com.poi.hr.dto.vacation.MyVacationListDTO;
import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.dto.vacation.VacationSaveDTO;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import com.poi.hr.repository.EmployeeRepository;
import com.poi.hr.repository.approval.DocTypeRepository;
import com.poi.hr.repository.vacation.VacationGrantHistoryRepository;
import com.poi.hr.repository.vacation.VacationRepository;
import com.poi.hr.repository.vacation.VacationReqRepository;
import com.poi.hr.repository.vacation.VacationTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;
    private final VacationTypeRepository vacationTypeRepository;
    private final VacationGrantHistoryRepository vacationGrantHistoryRepository;
    private final VacationReqRepository vacationReqRepository;
    private final EmployeeRepository employeeRepository;
    private final DocTypeRepository docTypeRepository;

    public VacationService(VacationRepository vacationRepository, VacationTypeRepository vacationTypeRepository, VacationGrantHistoryRepository vacationGrantHistoryRepository, VacationReqRepository vacationReqRepository, EmployeeRepository employeeRepository, DocTypeRepository docTypeRepository) {
        this.vacationRepository = vacationRepository;
        this.vacationTypeRepository = vacationTypeRepository;
        this.vacationGrantHistoryRepository = vacationGrantHistoryRepository;
        this.vacationReqRepository = vacationReqRepository;
        this.employeeRepository = employeeRepository;
        this.docTypeRepository = docTypeRepository;
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
        List<MyVacationListDTO> result = new ArrayList<>();

        // 1. 지급 내역 가져오기
        List<VacationGrantHistory> grants = vacationGrantHistoryRepository.findByEmployeeIdAndYear(employeeId, year);
        for (VacationGrantHistory grant : grants) {
            MyVacationListDTO dto = new MyVacationListDTO(
                    (long) grant.getVacGrantId(),
                    "지급",
                    grant.getVacationType().getVacTypeName(),
                    grant.getGrantDate().toString(),
                    grant.getGrantDate().toString(),
                    grant.getGrantedDays(),
                    "지급완료"
            );
            result.add(dto);
        }

        // 2. 차감 내역 가져오기
        List<VacationReq> reqs = vacationReqRepository.findByEmployeeIdAndYear(employeeId, year);
        for (VacationReq req : reqs) {
            MyVacationListDTO dto = new MyVacationListDTO(
                    (long) req.getApprovalDocId(),
                    "차감",
                    req.getVacationType().getVacTypeName(),
                    req.getVacReqStartDate().toString(),
                    req.getVacReqEndDate().toString(),
                    req.getVacUseDays(),
                    req.getApprovalStatus().getDisplayName()
            );
            result.add(dto);
        }

        return result;
    }

    /*
    결재 승인 API (서비스 레이어) 에서
    doc.setApprovalStatus(ApprovalStatus.APPROVED); 하고
    vacationService.processApprovedVacation(doc); 로 호출 예정
     */
    /* 휴가 차감 */
    @Transactional
    public void processApprovedVacation(ApprovalDoc approvalDoc) {
        // 1. 해당 결재문서에 연결된 휴가신청 내역 가져오기
        VacationReq req = vacationReqRepository.findByApprovalDocId(approvalDoc.getApprovalDocId());

        if (req == null) {
            throw new RuntimeException("휴가신청 내역 없음");
        }

        VacationBalance balance = vacationRepository
                .findVacationBalance(
                    approvalDoc.getEmployee().getEmployeeId(),
                    req.getVacationType().getVacTypeId(),
                    req.getVacReqStartDate().getYear()

                );

        if (balance == null) {
            throw new RuntimeException("잔여휴가 없음");
        }

        balance.setUsedVacCount(balance.getUsedVacCount() + req.getVacUseDays());
        balance.setRemainVacCount(balance.getRemainVacCount() - req.getVacUseDays());
    }

    /* 휴가 유형 전체 조회 */
    public List<VacationType> findAllVacationTypes() {
        return vacationTypeRepository.findAll();
    }

    /* 휴가 유형 조회 */
    public VacationType findById(int vacTypeId) {
        return vacationTypeRepository.findById(vacTypeId).orElse(null);
    }

    /* 휴가 결재 문서 저장 */
    @Transactional
    public void saveApprovalVacReq(VacationSaveDTO vacationSaveDTO, int loginUserId) {
        Employee employee = employeeRepository.findById(loginUserId).orElse(null);
        DocType docType = docTypeRepository.findByDocTypeCode(vacationSaveDTO.getDocTypeCode());

        VacationReq vacationReq = new VacationReq(
                employee,
                docType,
                vacationSaveDTO.getApprovalTitle(),
                vacationSaveDTO.getApprovalContent(),
                vacationSaveDTO.getApprovalReason(),

                vacationSaveDTO.getVacationType(),
                vacationSaveDTO.getVacReqStartDate(),
                vacationSaveDTO.getVacReqEndDate(),
                vacationSaveDTO.getVacUseDays()
        );

        vacationReqRepository.save(vacationReq);

        vacationSaveDTO.getApprovalLineList().get(0).setApprovalDocId(vacationReq.getApprovalDocId());
    }
}
