package com.poi.hr.controller;

import com.poi.hr.dto.AttendDTO;
import com.poi.hr.dto.CheckInDTO;
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
    // @AuthenticationPrincipal AuthDetails authDetails
    // 출근 시간 기록
    @PostMapping("/check-in")
    public ResponseEntity<String> checkIn(@RequestBody CheckInDTO checkInDTO/*, Principal principal*/) {

        logger.info("checkIn 등록 - controller");
        try {
            // int employeeId = Integer.parseInt(principal.getName());
            int employeeId = 4; // 임시 Id
            attendService.recordCheckIn(employeeId, checkInDTO.getCheckInTime());
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.status(500).body("fail");
        }

    }

}
