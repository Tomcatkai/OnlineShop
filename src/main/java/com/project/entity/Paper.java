package com.project.entity;

import java.util.Date;

public class Paper {
    private String paperId;

    private String paperName;

    private String paperIsProblem;

    private String paperCartype;

    private String paperFixStatus;

    private String paperTeacherId;

    private Date paperCreateTime;

    private Long paperUsingCount;

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId == null ? null : paperId.trim();
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public String getPaperIsProblem() {
        return paperIsProblem;
    }

    public void setPaperIsProblem(String paperIsProblem) {
        this.paperIsProblem = paperIsProblem == null ? null : paperIsProblem.trim();
    }

    public String getPaperCartype() {
        return paperCartype;
    }

    public void setPaperCartype(String paperCartype) {
        this.paperCartype = paperCartype == null ? null : paperCartype.trim();
    }

    public String getPaperFixStatus() {
        return paperFixStatus;
    }

    public void setPaperFixStatus(String paperFixStatus) {
        this.paperFixStatus = paperFixStatus == null ? null : paperFixStatus.trim();
    }

    public String getPaperTeacherId() {
        return paperTeacherId;
    }

    public void setPaperTeacherId(String paperTeacherId) {
        this.paperTeacherId = paperTeacherId == null ? null : paperTeacherId.trim();
    }

    public Date getPaperCreateTime() {
        return paperCreateTime;
    }

    public void setPaperCreateTime(Date paperCreateTime) {
        this.paperCreateTime = paperCreateTime;
    }

    public Long getPaperUsingCount() {
        return paperUsingCount;
    }

    public void setPaperUsingCount(Long paperUsingCount) {
        this.paperUsingCount = paperUsingCount;
    }
}