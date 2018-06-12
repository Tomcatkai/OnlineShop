package com.onlineshop.entity;

import java.util.List;

public class Classify {
    /**
     * 分类id
     */
    private String classifyId;

    /**
     * 分类名
     */
    private String classifyName;

    private String classifyPid;

    /**
     * 子分类集合
     */
    private List<Classify> childClassify;

    public List<Classify> getChildClassify() {
        return childClassify;
    }

    public void setChildClassify(List<Classify> childClassify) {
        this.childClassify = childClassify;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getClassifyPid() {
        return classifyPid;
    }

    public void setClassifyPid(String classifyPid) {
        this.classifyPid = classifyPid == null ? null : classifyPid.trim();
    }

    public Classify(String classifyId, String classifyName, String classifyPid, List<Classify> childClassify) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.classifyPid = classifyPid;
        this.childClassify = childClassify;
    }

    public Classify() {
    }
}