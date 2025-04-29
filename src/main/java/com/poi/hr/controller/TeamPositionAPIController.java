package com.poi.hr.controller;

import com.poi.hr.domain.hr.TeamPosition;
import com.poi.hr.repository.TeamPositionAPIRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@Validated
public class TeamPositionAPIController {

    private final TeamPositionAPIRepository teamPositionsRepository;

    public TeamPositionAPIController(TeamPositionAPIRepository teamPositionsRepository) {
        this.teamPositionsRepository = teamPositionsRepository;
    }

    // 직책 리스트 반환 API
    @GetMapping("/list")
    public List<TeamPosition> getAllPositions() {
        return teamPositionsRepository.findAll();
    }
}

