package com.poi.hr.controller;

import com.poi.hr.auth.model.AuthDetails;
import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.dto.CheckInDTO;
import com.poi.hr.dto.CheckOutDTO;
import com.poi.hr.service.AttendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendController {

    Logger logger = LoggerFactory.getLogger(AttendController.class.getName());
    private final AttendService attendService;

    @Autowired
    public AttendController(AttendService attendService) {
        this.attendService = attendService;
    }

    // 출근 등록
    @PostMapping("/check-in")
    public ResponseEntity<String> checkIn(@RequestBody CheckInDTO checkInDTO, @AuthenticationPrincipal UserDetails userDetails) {

        logger.info("checkIn 등록 - controller");
        try {
            AuthDetails authDetails = (AuthDetails) userDetails;
            int employeeId = ((AuthDetails) userDetails).getLoginEmployeeDto().getEmployeeId(); // 직원 id

            attendService.recordCheckIn(employeeId, checkInDTO.getCheckInTime());
            return ResponseEntity.ok("success");
        }catch (Exception e){
            return ResponseEntity.status(500).body("fail");
        }
    }

    // 출근 기록 조회
    @GetMapping("/todayCheckIn")
    public ResponseEntity<CheckInDTO> getTodayCheckIn(@AuthenticationPrincipal UserDetails userDetails) {

        logger.info("checkIn 확인 - controller");

        AuthDetails authDetails = (AuthDetails) userDetails;
        int employeeId = ((AuthDetails) userDetails).getLoginEmployeeDto().getEmployeeId();
        Optional<Attend> isAttend = attendService.getTodayAttendance(employeeId);

        if(isAttend.isPresent()){
            Attend att = isAttend.get();
            return ResponseEntity.ok(new CheckInDTO(att.getCheckInTime()));
        } else {
            return ResponseEntity.ok(null);
        }
    }

    // 퇴근 등록
    @PostMapping("/check-out")
    public ResponseEntity<String> checkOut(@RequestBody CheckOutDTO checkOutDTO, @AuthenticationPrincipal UserDetails userDetails) {
        logger.info("checkOut 등록 - controller");

        try {
            AuthDetails authDetails = (AuthDetails) userDetails;
            int employeeId = ((AuthDetails) userDetails).getLoginEmployeeDto().getEmployeeId();

            attendService.recordCheckOut(employeeId, checkOutDTO.getCheckOutTime());
            return ResponseEntity.ok("success");
        } catch(Exception e) {
            return ResponseEntity.status(500).body("fail");
        }
    }

    // 퇴근 기록 조회
    @GetMapping("/todayCheckOut")
    public ResponseEntity<CheckOutDTO> getTodayCheckOut(@AuthenticationPrincipal UserDetails userDetails) {
        logger.info("checkOut 확인 - controller");
        AuthDetails authDetails = (AuthDetails) userDetails;
        int employeeId = ((AuthDetails) userDetails).getLoginEmployeeDto().getEmployeeId();

        Optional<Attend> isCheckOut = attendService.getTodayCheckOut(employeeId);
        if(isCheckOut.get().getCheckOutStatus() == 'Y'){
            Attend att = isCheckOut.get();
            return ResponseEntity.ok(new CheckOutDTO(att.getCheckOutTime()));
        } else {
            return ResponseEntity.ok(null);
        }
    }

    // 출퇴근 정정 폼 제출
    @PostMapping("/attend-req/save")
    public ResponseEntity<String> saveAttendFixDoc(@RequestBody Map<String, Object> request) {

        // 결재 등록 함수 호출 필요

        return ResponseEntity.ok("success");
    }


}

