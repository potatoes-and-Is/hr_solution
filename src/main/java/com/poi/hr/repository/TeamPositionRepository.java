package com.poi.hr.repository;

import com.poi.hr.domain.employee.TeamPositions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamPositionRepository extends JpaRepository<TeamPositions, Integer> {

    // 직책명으로 조회 (옵션)
    TeamPositions findByPositionName(String positionName);
}
