package com.poi.hr.controller.vacation;

import com.poi.hr.domain.vacation.ApprovalDoc;
import com.poi.hr.domain.vacation.enums.ApprovalDocStatus;
import com.poi.hr.repository.vacation.ApprovalDocRepository;
import com.poi.hr.service.VacationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/vacation")
public class VacationTestController {

    private final VacationService vacationService;
    private final ApprovalDocRepository approvalDocRepository;

    public VacationTestController(VacationService vacationService, ApprovalDocRepository approvalDocRepository) {
        this.vacationService = vacationService;
        this.approvalDocRepository = approvalDocRepository;
    }

    @PostMapping("/approve")
    @ResponseBody
    public String approveVacation(@RequestParam("approvalDocId") int approvalDocId) {
        //1. 결재문서 조회
        ApprovalDoc approvalDoc = approvalDocRepository.findByApprovalDocId(approvalDocId);

        if (approvalDoc == null) {
            throw new RuntimeException("approvalDoc is null");
        }

        //2. 결재상태 APPROVED로 변경
        approvalDoc.setApprovalDocStatus(ApprovalDocStatus.APPROVED);

        //3. 휴가 차감 로직 호출
        vacationService.processApprovedVacation(approvalDoc);

        return "휴가 승인 완료";
    }


}
