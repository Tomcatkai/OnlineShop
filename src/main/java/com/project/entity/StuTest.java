package com.project.entity;

public class StuTest {
    private String stuTestId;

    private String stuId;

    private String testId;

    public String getStuTestId() {
        return stuTestId;
    }

    public void setStuTestId(String stuTestId) {
        this.stuTestId = stuTestId == null ? null : stuTestId.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }
}