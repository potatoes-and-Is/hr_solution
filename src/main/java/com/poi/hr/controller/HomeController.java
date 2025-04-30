package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.dto.AttendDTO;
import com.poi.hr.service.AttendService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomeController {

    private final AttendService attendService;

    public HomeController(AttendService attendService) {
        this.attendService = attendService;
    }

    @GetMapping({"/", "/poihr"})
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails.getAuthorities());

        model.addAttribute("title", "Home");

        AuthDetails authDetails = (AuthDetails) userDetails;
        model.addAttribute("userName", authDetails.getEmployeeName()); // 이름
        model.addAttribute("userRole", authDetails.getLoginEmployeeDto().getEmployeeRole().getRoleName()); // 직책(팀장, 팀원 등)

        // 현재 시간 (yyyy.MM.dd(E) HH:mm:ss)
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd(E) HH:mm:ss"));
        model.addAttribute("currentDateTime", currentDateTime);

        return "index";
    }

    /* 출퇴근 내역확인 탭 */
    @GetMapping("/attendanceList")
    public ModelAndView attendanceList(ModelAndView mv, @AuthenticationPrincipal UserDetails userDetails) {

        AuthDetails authDetails = (AuthDetails) userDetails;
        int employeeId = authDetails.getLoginEmployeeDto().getEmployeeId(); // 직원 Id
        List<AttendDTO> attendList = attendService.getAttendList(employeeId);

        // 출퇴근 리스트 정보 반환
        mv.addObject("attendList", attendList);
        // 뷰 이름 반환
        mv.setViewName("attendance/attendanceList");
        return mv;
    }

    @GetMapping("/approval/detail")
    public String approval() {
        return "approval/detail";
    }
}
