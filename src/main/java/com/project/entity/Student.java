package com.project.entity;

public class Student {
    private String stuId;

    private String stuName;

    private String stuNo;

    private String stuSex;

    private String stuClassId;

    private String stuNotice;

    private String stuRole;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public String getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId == null ? null : stuClassId.trim();
    }

    public String getStuNotice() {
        return stuNotice;
    }

    public void setStuNotice(String stuNotice) {
        this.stuNotice = stuNotice == null ? null : stuNotice.trim();
    }

    public String getStuRole() {
        return stuRole;
    }

    public void setStuRole(String stuRole) {
        this.stuRole = stuRole == null ? null : stuRole.trim();
    }
}