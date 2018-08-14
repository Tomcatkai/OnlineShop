package com.project.entity;

public class Score {
    private String scoreId;

    private String scoreStuId;

    private String scoreTestId;

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId == null ? null : scoreId.trim();
    }

    public String getScoreStuId() {
        return scoreStuId;
    }

    public void setScoreStuId(String scoreStuId) {
        this.scoreStuId = scoreStuId == null ? null : scoreStuId.trim();
    }

    public String getScoreTestId() {
        return scoreTestId;
    }

    public void setScoreTestId(String scoreTestId) {
        this.scoreTestId = scoreTestId == null ? null : scoreTestId.trim();
    }
}