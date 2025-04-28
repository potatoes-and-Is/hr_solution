package com.poi.hr.domain.employee;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue
    @Column(name = "level_id")
    private int levelId;
    @Column(name = "level_code", nullable = false, length = 50)
    private String levelCode;
    @Column(name = "level_name", nullable = false, length = 50)
    private String levelName;
    @Column(name = "created_by", nullable = false, length = 30)
    private String createdBy;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Level() {

    }

    public Level(int levelId, String levelCode, String levelName, String createdBy, LocalDateTime createdAt) {
        this.levelId = levelId;
        this.levelCode = levelCode;
        this.levelName = levelName;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String created_by) {
        this.createdBy = created_by;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String level_Name) {
        this.levelName = level_Name;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String level_Code) {
        this.levelCode = level_Code;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int level_id) {
        this.levelId = level_id;
    }

    @Override
    public String toString() {
        return "Levels{" +
                "level_id=" + levelId +
                ", level_Code='" + levelCode + '\'' +
                ", level_Name='" + levelName + '\'' +
                ", created_by='" + createdBy + '\'' +
                ", created_at=" + createdAt +
                '}';
    }
}
