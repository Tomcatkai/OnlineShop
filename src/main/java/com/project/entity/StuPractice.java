package com.project.entity;

public class StuPractice {
    private String stuPracticeId;

    private String stuId;

    private String practiceId;

    public String getStuPracticeId() {
        return stuPracticeId;
    }

    public void setStuPracticeId(String stuPracticeId) {
        this.stuPracticeId = stuPracticeId == null ? null : stuPracticeId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId == null ? null : practiceId.trim();
    }
}