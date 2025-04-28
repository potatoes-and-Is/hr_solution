package com.poi.hr.controller;

import com.poi.hr.domain.employee.Level;
import com.poi.hr.repository.LevelRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@Validated
public class LevelController {

    private final LevelRepository levelRepository;

    public LevelController(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @GetMapping("/list")
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }
}

