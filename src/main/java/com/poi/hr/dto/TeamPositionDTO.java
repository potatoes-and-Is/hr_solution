package com.poi.hr.dto;

public class TeamPositionDTO {
    private int teamPositionId;
    private String positionName;

    public TeamPositionDTO(int teamPositionId, String positionName) {
        this.teamPositionId = teamPositionId;
        this.positionName = positionName;
    }

    public int getTeamPositionId() {
        return teamPositionId;
    }

    public String getPositionName() {
        return positionName;
    }
}
