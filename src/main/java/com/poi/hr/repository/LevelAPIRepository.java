package com.poi.hr.repository;

import com.poi.hr.domain.hr.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelAPIRepository extends JpaRepository<Level, Integer> {
}
