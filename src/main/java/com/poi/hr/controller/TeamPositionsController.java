package com.poi.hr.controller;

import com.poi.hr.domain.employee.TeamPositions;
import com.poi.hr.repository.TeamPositionRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@Validated
public class TeamPositionsController {

    private final TeamPositionRepository teamPositionsRepository;

    public TeamPositionsController(TeamPositionRepository teamPositionsRepository) {
        this.teamPositionsRepository = teamPositionsRepository;
    }

    // 직책 리스트 반환 API
    @GetMapping("/list")
    public List<TeamPositions> getAllPositions() {
        return teamPositionsRepository.findAll();
    }
}

