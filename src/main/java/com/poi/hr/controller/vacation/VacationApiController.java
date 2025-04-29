package com.poi.hr.controller.vacation;

import com.poi.hr.dto.vacation.VacationTypeResDTO;
import com.poi.hr.service.VacationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poihr/api/vacation")
public class VacationApiController {

    private final VacationService vacationService;

    public VacationApiController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/types")
    public List<VacationTypeResDTO> getAllVacationTypes() {
        return vacationService.getAllVacationTypes();
    }

    @PostMapping("/vac-req/save")
    public ResponseEntity<String> saveApprovalDocument(@RequestBody Map<String, Object> request) {

        //결재 등록하기 함수 호출 필요

        return ResponseEntity.ok("결재 문서 올리기 완료");
    }
}
