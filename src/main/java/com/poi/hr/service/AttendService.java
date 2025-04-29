package com.poi.hr.service;

import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.domain.attendance.AttendStatus;
import com.poi.hr.domain.login.entity.Employee;
import com.poi.hr.dto.AttendDTO;
import com.poi.hr.repository.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttendService {

    private final AttendRepository attendRepository;

    @Autowired
    public AttendService(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    // 오늘의 근무 가져오기
    public Optional<Attend> getTodayAttendance(int employeeId) {
        return attendRepository.findByEmployeeEmployeeIdAndAttendDate(employeeId, LocalDate.now());
    }

    // 오늘의 퇴근 기록 가져오기
    public Optional<Attend> getTodayCheckOut(int employeeId) {
        return attendRepository.findCheckOutStatusByEmployeeEmployeeIdAndAttendDate(employeeId, LocalDate.now());
    }

    // 출근 등록
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

    // 퇴근 등록
    @Transactional
    public void recordCheckOut(int employeeId, LocalTime checkOutTime) {

        LocalDate today = LocalDate.now();
        Optional<Attend> existAttend = attendRepository.findByEmployeeEmployeeIdAndAttendDate(employeeId, today);

        if(!existAttend.isPresent()){
            throw new IllegalArgumentException("오늘 출근 기록이 없습니다.");
        }

        Attend updateAttend = existAttend.get();
        if(updateAttend.getCheckOutTime() != null) {
            throw new IllegalArgumentException("이미 퇴근 기록이 존재합니다.");
        } else {
            updateAttend.setCheckOutTime(checkOutTime);
            updateAttend.setCheckOutStatus('Y');
            updateAttend.setAttendStatus(calculateAttendStatus(updateAttend.getCheckInTime(), checkOutTime));
        }

        attendRepository.save(updateAttend);
    }

    // 출근 시간 체크 (정상 or 지각)
    public AttendStatus calculateCheckInTime(LocalTime checkInTime){
        LocalTime checkIn = LocalTime.of(10, 0);
        if(checkInTime.isAfter(checkIn)){
            return AttendStatus.LATE;
        } else {
            return AttendStatus.WORK;
        }
    }

    // 출근 상태 체크(정상, 지각, 조퇴)
    public AttendStatus calculateAttendStatus(LocalTime checkInTime, LocalTime checkOutTime){

        LocalTime checkIn = LocalTime.of(9, 30); // 9시반 출근 기준
        LocalTime checkOut = LocalTime.of(18, 30); // 6시반 퇴근 기준
        if(checkOutTime.isBefore(checkOut)){
            return AttendStatus.EARLY_LEAVE;
        } else if(checkInTime.isAfter(checkIn)) {
            return AttendStatus.LATE;
        } else {
            return AttendStatus.WORK;
        }
    }

    // 출퇴근내역 조회
    @Transactional
    public List<AttendDTO> getAttendList(int employeeId) {

        List<Attend> attendList =  attendRepository.findAllByEmployeeEmployeeId(employeeId);
        List<AttendDTO> saveAttendList = new ArrayList<>();

        if(attendList.isEmpty() || attendList == null){
            throw new IllegalArgumentException("조회된 출퇴근 내역이 없습니다.");
        }

        attendList.forEach(attend -> saveAttendList.add(new AttendDTO(attend.getAttendId(), attend.getAttendDate(), attend.getCheckInTime(), attend.getCheckOutTime(), attend.getAttendStatus())));

        return saveAttendList;
    }
}
