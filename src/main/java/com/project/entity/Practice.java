package com.project.entity;

import java.util.Date;

public class Practice {
    private String practiceId;

    private String practiceName;

    private String practicePaperId;

    private String practiceStatus;

    private Date practiceCreatetime;

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId == null ? null : practiceId.trim();
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName == null ? null : practiceName.trim();
    }

    public String getPracticePaperId() {
        return practicePaperId;
    }

    public void setPracticePaperId(String practicePaperId) {
        this.practicePaperId = practicePaperId == null ? null : practicePaperId.trim();
    }

    public String getPracticeStatus() {
        return practiceStatus;
    }

    public void setPracticeStatus(String practiceStatus) {
        this.practiceStatus = practiceStatus == null ? null : practiceStatus.trim();
    }

    public Date getPracticeCreatetime() {
        return practiceCreatetime;
    }

    public void setPracticeCreatetime(Date practiceCreatetime) {
        this.practiceCreatetime = practiceCreatetime;
    }
}