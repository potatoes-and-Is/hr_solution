package com.poi.hr.controller;

import com.poi.hr.dto.AttendDTO;
import com.poi.hr.service.AttendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/attendance")
public class AttendController {

    Logger logger = LoggerFactory.getLogger(AttendController.class.getName());
    private final AttendService attendService;

    @Autowired
    public AttendController(AttendService attendService) {
        this.attendService = attendService;
    }

    // 출근 버튼 눌렀을 때 넘겨줘야 하는 정보 : employee_id / 출,퇴근 시간 /

    // 출근 시간 기록
    @PostMapping("/check-in")
    public ResponseEntity<AttendDTO> checkIn(@RequestBody AttendDTO attendDTO, Principal principal) {
        String employeeId = principal.getName();
        attendService.recordCheckIn(attendDTO);
    }



}
