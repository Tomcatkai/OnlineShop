package com.project.entity;

public class PracticeScoreItem {
    private String scoreitemId;

    private String scoreitemCheckpoint;

    private String scoreitemScoreid;

    private String scoreitemUseroperation;

    private String scoreitemCheckresult;

    private String scoreitemScore;

    public String getScoreitemId() {
        return scoreitemId;
    }

    public void setScoreitemId(String scoreitemId) {
        this.scoreitemId = scoreitemId == null ? null : scoreitemId.trim();
    }

    public String getScoreitemCheckpoint() {
        return scoreitemCheckpoint;
    }

    public void setScoreitemCheckpoint(String scoreitemCheckpoint) {
        this.scoreitemCheckpoint = scoreitemCheckpoint == null ? null : scoreitemCheckpoint.trim();
    }

    public String getScoreitemScoreid() {
        return scoreitemScoreid;
    }

    public void setScoreitemScoreid(String scoreitemScoreid) {
        this.scoreitemScoreid = scoreitemScoreid == null ? null : scoreitemScoreid.trim();
    }

    public String getScoreitemUseroperation() {
        return scoreitemUseroperation;
    }

    public void setScoreitemUseroperation(String scoreitemUseroperation) {
        this.scoreitemUseroperation = scoreitemUseroperation == null ? null : scoreitemUseroperation.trim();
    }

    public String getScoreitemCheckresult() {
        return scoreitemCheckresult;
    }

    public void setScoreitemCheckresult(String scoreitemCheckresult) {
        this.scoreitemCheckresult = scoreitemCheckresult == null ? null : scoreitemCheckresult.trim();
    }

    public String getScoreitemScore() {
        return scoreitemScore;
    }

    public void setScoreitemScore(String scoreitemScore) {
        this.scoreitemScore = scoreitemScore == null ? null : scoreitemScore.trim();
    }
}