package com.poi.hr.controller.vacation;

import com.poi.hr.dto.vacation.MyVacationListDTO;
import com.poi.hr.dto.vacation.VacationBalanceDTO;
import com.poi.hr.service.VacationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/poihr/vacation")
public class MyVacationController {

    private final VacationService vacationService;

    public MyVacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    //나의 휴가 - 대시정보 조회, 상세내역 조회
    @GetMapping("/my")
    public String getMyVacation(
            @RequestParam(value = "year", required = false) Integer year,
            Model model) {

        int employeeId = 2;  //임시 아이디

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

        //5. 모델에 담기
        model.addAttribute("vacationInfo", vacationInfo);
        model.addAttribute("vacations", vacaionList);
        model.addAttribute("years", years);
        model.addAttribute("selectedYear", year);

        return "vacation/my-vacation";
    }

    @GetMapping("/test-page")
    public String showTestPage() {
        return "vacation/approvalTest";
    }




}
