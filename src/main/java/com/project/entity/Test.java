package com.project.entity;

import java.util.Date;

public class Test {
    private String testId;

    private String testName;

    private String testPaperId;

    private String testStatus;

    private Date testCreatetime;

    private Date testStarttime;

    private Date testOvertime;

    private String testTeacherId;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId == null ? null : testId.trim();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public String getTestPaperId() {
        return testPaperId;
    }

    public void setTestPaperId(String testPaperId) {
        this.testPaperId = testPaperId == null ? null : testPaperId.trim();
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus == null ? null : testStatus.trim();
    }

    public Date getTestCreatetime() {
        return testCreatetime;
    }

    public void setTestCreatetime(Date testCreatetime) {
        this.testCreatetime = testCreatetime;
    }

    public Date getTestStarttime() {
        return testStarttime;
    }

    public void setTestStarttime(Date testStarttime) {
        this.testStarttime = testStarttime;
    }

    public Date getTestOvertime() {
        return testOvertime;
    }

    public void setTestOvertime(Date testOvertime) {
        this.testOvertime = testOvertime;
    }

    public String getTestTeacherId() {
        return testTeacherId;
    }

    public void setTestTeacherId(String testTeacherId) {
        this.testTeacherId = testTeacherId == null ? null : testTeacherId.trim();
    }
}