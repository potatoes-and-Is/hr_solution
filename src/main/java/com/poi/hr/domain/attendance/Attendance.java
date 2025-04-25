package com.poi.hr.domain.attendance;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "Attends")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attend_id")
    private int attendId;

    @Column(name = "attend_date")
    private LocalDateTime attendDate;

    @Column(name = "check_in_time")
    private LocalTime checkInTime;

    @Column(name = "check_out_time")
    private LocalTime checkOutTime;

    @Column(name = "check_in_status")
    private char checkInStatus;

    @Column(name = "check_out_status")
    private char checkOutStatus;

    // attendStatus Enum 추가
    // employeeid fk 추가
}
