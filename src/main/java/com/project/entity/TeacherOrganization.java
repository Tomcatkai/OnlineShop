package com.project.entity;

public class TeacherOrganization {
    private String teacherOrgId;

    private String teacherId;

    private String orgId;

    public String getTeacherOrgId() {
        return teacherOrgId;
    }

    public void setTeacherOrgId(String teacherOrgId) {
        this.teacherOrgId = teacherOrgId == null ? null : teacherOrgId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}