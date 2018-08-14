package com.project.dao;

import com.project.entity.TeacherOrganization;

public interface TeacherOrganizationDao {
    int deleteByPrimaryKey(String teacherOrgId);

    int insert(TeacherOrganization record);

    int insertSelective(TeacherOrganization record);

    TeacherOrganization selectByPrimaryKey(String teacherOrgId);

    int updateByPrimaryKeySelective(TeacherOrganization record);

    int updateByPrimaryKey(TeacherOrganization record);
}