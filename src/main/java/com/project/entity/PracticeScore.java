package com.project.entity;

public class PracticeScore {
    private String practiceScoreId;

    private String practiceScoreStuId;

    private String practiceId;

    public String getPracticeScoreId() {
        return practiceScoreId;
    }

    public void setPracticeScoreId(String practiceScoreId) {
        this.practiceScoreId = practiceScoreId == null ? null : practiceScoreId.trim();
    }

    public String getPracticeScoreStuId() {
        return practiceScoreStuId;
    }

    public void setPracticeScoreStuId(String practiceScoreStuId) {
        this.practiceScoreStuId = practiceScoreStuId == null ? null : practiceScoreStuId.trim();
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId == null ? null : practiceId.trim();
    }
}