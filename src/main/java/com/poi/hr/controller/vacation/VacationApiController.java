package com.poi.hr.controller.vacation;

import com.poi.hr.dto.vacation.VacationTypeResDTO;
import com.poi.hr.service.VacationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
