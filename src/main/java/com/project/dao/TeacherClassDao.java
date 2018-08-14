package com.project.dao;

import com.project.entity.TeacherClass;

public interface TeacherClassDao {
    int deleteByPrimaryKey(String teacherClassId);

    int insert(TeacherClass record);

    int insertSelective(TeacherClass record);

    TeacherClass selectByPrimaryKey(String teacherClassId);

    int updateByPrimaryKeySelective(TeacherClass record);

    int updateByPrimaryKey(TeacherClass record);
}