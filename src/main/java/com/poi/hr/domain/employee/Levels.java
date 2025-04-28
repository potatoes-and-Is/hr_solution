package com.poi.hr.domain.employee;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "levels")
public class Levels {

    @Id
    @GeneratedValue
    @Column
    private int level_id;
    @Column
    private String level_Code;
    @Column
    private String level_Name;
    @Column
    private String created_by;
    @Column
    private LocalDateTime created_at;

    public Levels() {

    }

    public Levels(int level_id, String level_Code, String level_Name, String created_by, LocalDateTime created_at) {
        this.level_id = level_id;
        this.level_Code = level_Code;
        this.level_Name = level_Name;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLevel_Name() {
        return level_Name;
    }

    public void setLevel_Name(String level_Name) {
        this.level_Name = level_Name;
    }

    public String getLevel_Code() {
        return level_Code;
    }

    public void setLevel_Code(String level_Code) {
        this.level_Code = level_Code;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    @Override
    public String toString() {
        return "Levels{" +
                "level_id=" + level_id +
                ", level_Code='" + level_Code + '\'' +
                ", level_Name='" + level_Name + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
