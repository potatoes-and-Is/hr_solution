package com.poi.hr.repository;

import com.poi.hr.domain.employee.TeamPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamPositionRepository extends JpaRepository<TeamPosition, Integer> {

    // 직책명으로 조회 (옵션)
    TeamPosition findByPositionName(String positionName);
}
