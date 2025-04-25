package com.poi.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {

    // 출근 버튼 눌렀을 때 받아와야 하는 정보 : employee_id / 현재 시간 /
    /* 출퇴근 탭 */
    @GetMapping("/attendanceList")
    public String attendanceList(Model model) {
        model.addAttribute("title", "Attendance List");
        return "attendance/attendanceList";
    }

}
