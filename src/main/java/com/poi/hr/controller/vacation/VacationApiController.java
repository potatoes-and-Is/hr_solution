package com.poi.hr.controller.vacation;

import com.poi.hr.dto.vacation.VacationResponseDTO;
import com.poi.hr.dto.vacation.VacationTypeResDTO;
import com.poi.hr.service.VacationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vacation")
public class VacationApiController {

    private final VacationService vacationService;

    public VacationApiController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/types")
    public List<VacationTypeResDTO> getAllVacationTypes() {
        return vacationService.getAllVacationTypes();
    }

    /* 세션에 모달 휴가 정보 저장 */
    @PostMapping("/temp/save-to-session")
    public ResponseEntity<Void> saveTempToSession(@RequestBody VacationResponseDTO vacationResponseDTO, HttpSession session) {
        session.setAttribute("vacationResponseDTO", vacationResponseDTO);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/save/vac-req")
//    public ResponseEntity<VacationResponseDTO> saveApprovalDocument(@RequestBody VacationResponseDTO vacationResponseDTO) {
//        return ResponseEntity.ok(vacationResponseDTO);
//    }
}
