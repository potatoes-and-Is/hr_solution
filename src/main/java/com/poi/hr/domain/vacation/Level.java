package com.poi.hr.domain.vacation;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer levelId;

    @Column(name = "level_code", nullable = false, length = 50)
    private String levelCode;

    @Column(name = "level_name", nullable = false, length = 50)
    private String levelName;

    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    //기본생성자
    public Level() {
    }

    public Level(String levelCode, String levelName, String createdBy) {
        this.levelCode = levelCode;
        this.levelName = levelName;
        this.createdBy = createdBy;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                ", levelCode='" + levelCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
