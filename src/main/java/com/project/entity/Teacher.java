package com.project.entity;

public class Teacher {
    private String teacherId;

    private String teacherName;

    private String teacherSex;

    private String teacherLoginName;

    private String teacherClassId;

    private String teacherOrgId;

    private String teacherLoginPwd;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex == null ? null : teacherSex.trim();
    }

    public String getTeacherLoginName() {
        return teacherLoginName;
    }

    public void setTeacherLoginName(String teacherLoginName) {
        this.teacherLoginName = teacherLoginName == null ? null : teacherLoginName.trim();
    }

    public String getTeacherClassId() {
        return teacherClassId;
    }

    public void setTeacherClassId(String teacherClassId) {
        this.teacherClassId = teacherClassId == null ? null : teacherClassId.trim();
    }

    public String getTeacherOrgId() {
        return teacherOrgId;
    }

    public void setTeacherOrgId(String teacherOrgId) {
        this.teacherOrgId = teacherOrgId == null ? null : teacherOrgId.trim();
    }

    public String getTeacherLoginPwd() {
        return teacherLoginPwd;
    }

    public void setTeacherLoginPwd(String teacherLoginPwd) {
        this.teacherLoginPwd = teacherLoginPwd == null ? null : teacherLoginPwd.trim();
    }
}