package com.poi.hr.repository;

import com.poi.hr.domain.employee.Levels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Levels, Integer> {
}
