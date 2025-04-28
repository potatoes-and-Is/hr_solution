package com.poi.hr.service;

import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.domain.attendance.AttendStatus;
import com.poi.hr.domain.employee.Employee;
import com.poi.hr.dto.AttendDTO;
import com.poi.hr.repository.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AttendService {

    private final AttendRepository attendRepository;

    @Autowired
    public AttendService(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    // 출근 시간 기록
    @Transactional
    public void recordCheckIn(int employeeId, LocalTime checkInTime){
        LocalDate today = LocalDate.now();

        Optional<Attend> findAttend = attendRepository.findByEmployeeEmployeeIdAndAttendDate(employeeId, today);

        if(findAttend.isPresent()){
            throw new IllegalArgumentException("이미 출근기록이 존재합니다.");
        }

        Attend attend = new Attend();

        attend.setAttendDate(today);
        attend.setCheckInTime(checkInTime);
        attend.setCheckInStatus('Y');
        attend.setAttendStatus(calculateCheckInTime(checkInTime)); // 정상 or 지각
        attend.setEmployee(new Employee(employeeId));

        attendRepository.save(attend);
    }

    // 출근 시간 체크 (정상 or 지각)
    public AttendStatus calculateCheckInTime(LocalTime checkInTime){
        LocalTime checkIn = LocalTime.of(9, 0);
        if(checkInTime.isAfter(checkIn)){
            return AttendStatus.LATE;
        } else {
            return AttendStatus.WORK;
        }

    }

    // 출근 상태 체크(정상, 지각, 조퇴)
    public AttendStatus calculateAttendStatus(LocalTime checkInTime, LocalTime checkOutTime){

        LocalTime checkIn = LocalTime.of(9, 0); // 9시 출근 기준
        LocalTime checkOut = LocalTime.of(18, 0);
        if(checkInTime.isAfter(checkIn)){
            return AttendStatus.LATE;
        } else if(checkOutTime.isBefore(checkOut)) {
            return AttendStatus.EARLY_LEAVE;
        } else {
            return AttendStatus.WORK;
        }
    }
}
