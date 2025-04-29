package com.poi.hr.controller;

import com.poi.hr.domain.hr.Level;
import com.poi.hr.repository.LevelAPIRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@Validated
public class LevelAPIController {

    private final LevelAPIRepository levelAPIRepository;

    public LevelAPIController(LevelAPIRepository levelAPIRepository) {
        this.levelAPIRepository = levelAPIRepository;
    }

    @GetMapping("/list")
    public List<Level> getAllLevels() {
        return levelAPIRepository.findAll();
    }
}

