package com.project.entity;

public class TeacherClass {
    private String teacherClassId;

    private String teacherId;

    private String classId;

    public String getTeacherClassId() {
        return teacherClassId;
    }

    public void setTeacherClassId(String teacherClassId) {
        this.teacherClassId = teacherClassId == null ? null : teacherClassId.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}