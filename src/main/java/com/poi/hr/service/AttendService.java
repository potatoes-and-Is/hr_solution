package com.poi.hr.service;

import com.poi.hr.domain.attendance.Attend;
import com.poi.hr.dto.AttendDTO;
import com.poi.hr.repository.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendService {

    private final AttendRepository attendRepository;

    @Autowired
    public AttendService(AttendRepository attendRepository) {
        this.attendRepository = attendRepository;
    }

    // 출근 시간 기록
    public void recordCheckIn(AttendDTO attendDTO){
        Attend attend =  attendRepository.save();
    }
}
