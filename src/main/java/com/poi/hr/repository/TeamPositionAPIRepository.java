package com.poi.hr.repository;

import com.poi.hr.domain.hr.TeamPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamPositionAPIRepository extends JpaRepository<TeamPosition, Integer> {

    // 직책명으로 조회 (옵션)
    TeamPosition findByPositionName(String positionName);
}
