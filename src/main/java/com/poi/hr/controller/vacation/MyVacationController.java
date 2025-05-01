package com.poi.hr.controller.vacation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.dept.DepPositionEmployee;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.domain.vacation.VacationType;
import com.poi.hr.domain.vacation.enums.LeaveType;
import com.poi.hr.dto.approval.ApprovalEmpLeaveSaveDto;
import com.poi.hr.dto.approval.ApprovalEmpLeaveViewDto;
import com.poi.hr.dto.approval.EmployeeDto;
import com.poi.hr.dto.vacation.*;
import com.poi.hr.service.DeptService;
import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.dept.Dept;
import com.poi.hr.dto.DeptDTO;
import com.poi.hr.dto.vacation.DepartmentVacationDto;
import com.poi.hr.dto.vacation.MyVacationListDTO;
import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.service.VacationService;
import com.poi.hr.service.approval.ApprovalLineService;
import com.poi.hr.util.SecurityUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vacation")
public class MyVacationController {

    private final VacationService vacationService;
    private final DeptService deptService;
    private final ApprovalLineService approvalLineService;

    public MyVacationController(VacationService vacationService, DeptService deptService, ApprovalLineService approvalLineService) {
        this.vacationService = vacationService;
        this.deptService = deptService;
        this.approvalLineService = approvalLineService;
    }

    public int loginUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails principal = (AuthDetails) auth.getPrincipal();
        return principal.getLoginEmployeeDto().getEmployeeId();
    }

    //나의 휴가 - 대시정보 조회, 상세내역 조회
    @GetMapping("/my")
    public String getMyVacation(
            @RequestParam(value = "year", required = false) Integer year,
            Model model) {

        //0. 로그인 사용자 정보 가져오기
        int employeeId = SecurityUtil.getCurrentEmployeeId();

        //1. year 없으면 올해 년도로 지정
        if (year == null) { //null 체크를 했기에 서비스 레이어에서 int로 매개변수 받을 수 있음
            year = LocalDate.now().getYear();
        }

        //2. 상단 대시보드 데이터 가져오기 (총, 사용, 남은 휴가)
        VacationBalanceDTO vacationInfo = vacationService.getTotalVacationInfo(employeeId, year);

        //3. 휴가 상세 리스트 가져오기
        List<MyVacationListDTO> vacaionList = vacationService.getMyVacationList(employeeId, year);

        //4. 연도 선택용 year 리스트
        List<Integer> years = vacationService.getAvailableYears(employeeId);

        /* 휴가 유형 */
        List<VacationType> vacationTypeList = vacationService.findAllVacationTypes();

        //5. 모델에 담기
        model.addAttribute("vacationInfo", vacationInfo);
        model.addAttribute("vacations", vacaionList);
        model.addAttribute("years", years);
        model.addAttribute("selectedYear", year);
        model.addAttribute("vacationTypeList", vacationTypeList);

        return "vacation/my-vacation";
    }

    @GetMapping("/test-page")
    public String showTestPage() {
        return "vacation/approvalTest";
    }

    /* 휴가 신청서 작성 */
    @GetMapping("/save/vac-req")
    public String saveApprovalDocument(HttpSession session, Model model) throws JsonProcessingException {
        VacationResponseDTO vacationResponseDTO = (VacationResponseDTO) session.getAttribute("vacationResponseDTO");
        VacationType vacationType =  vacationService.findById(vacationResponseDTO.getVacTypeId());

        VacationSaveDTO dto = new VacationSaveDTO();
        dto.setDocTypeCode("vacation_request");
        dto.setVacationType(vacationType);
        dto.setVacUseDays(vacationResponseDTO.getVacUseDay());
        dto.setVacReqStartDate(vacationResponseDTO.getVacReqStartDate());
        dto.setVacReqEndDate(vacationResponseDTO.getVacReqEndDate());
        dto.setApprovalReason(vacationResponseDTO.getApprovalReason());

        model.addAttribute("vacationSaveDTO", dto);
        model.addAttribute("docTypeCode", dto.getDocTypeCode());
        model.addAttribute("vacReqStartDate", dto.getVacReqStartDate());
        model.addAttribute("vacReqEndDate", dto.getVacReqEndDate());
        model.addAttribute("vacUseDays", dto.getVacUseDays());
        model.addAttribute("vacationType", dto.getVacationType());

        List<Dept> deptList = deptService.findAllDepts();
        List<VacationType> vacationTypeList = vacationService.findAllVacationTypes();
        List<DepPositionEmployee> all = deptService.findAllWithDeptAndEmployee();

        Map<String, List<EmployeeDto>> deptEmpMap = new HashMap<>();
        for (DepPositionEmployee dpe : all) {
            String deptIdStr = String.valueOf(dpe.getDept().getDeptId());
            EmployeeDto empDto = new EmployeeDto(
                    dpe.getEmployee().getEmployeeId(),
                    dpe.getEmployee().getEmployeeName()
            );
            deptEmpMap.computeIfAbsent(deptIdStr, k -> new ArrayList<>()).add(empDto);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String deptEmpMapJson = objectMapper.writeValueAsString(deptEmpMap);

        model.addAttribute("deptEmpMap", deptEmpMap);  // Thymeleaf select 옵션용
        model.addAttribute("deptEmpMapJson", deptEmpMapJson);  // JavaScript에서 쓸 JSON 문자열
        model.addAttribute("vacationViewDTO", new VacationViewDTO(vacationTypeList, deptList));

        return "vacation/save/vac-req";
    }

    /* 휴가 신청서 저장 */
    @PostMapping("/save/vac-req")
    public String SaveEmpLeave(@ModelAttribute VacationSaveDTO vacationSaveDTO) {
        vacationService.saveApprovalVacReq(vacationSaveDTO, loginUserId());
        approvalLineService.saveApprovalLine(vacationSaveDTO.getApprovalLineList());
        return "redirect:/approval/list";
    }

    @GetMapping("/department")
    public String showDeptVacation(@RequestParam(required = false) Integer deptId, Model model) {
        // 모든 부서 정보 조회해서 드롭다운에 사용
        List<Dept> departments = vacationService.getAllDepartments();
        model.addAttribute("departments", departments);

        // 부서가 선택된 경우에만 휴가 내역 조회
        if (deptId != null) {
            List<DepartmentVacationDto> vacations = vacationService.getApprovedVacationsByDeptId(deptId);
            model.addAttribute("vacations", vacations);
        }

        return "vacation/dept-vacation";
    }
}
