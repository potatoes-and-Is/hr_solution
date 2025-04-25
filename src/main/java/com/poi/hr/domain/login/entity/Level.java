package com.poi.hr.domain.login.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id", nullable = false)
    private Integer levelId;

    @Column(name = "level_code", nullable = false, unique = true)
    private String levelCode;

    @Column(name = "level_name", nullable = false)
    private String levelName;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    public Level() {
    }

    public Level(Integer levelId, String levelCode, String levelName, String createdBy, LocalDateTime createdAt) {
        this.levelId = levelId;
        this.levelCode = levelCode;
        this.levelName = levelName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
