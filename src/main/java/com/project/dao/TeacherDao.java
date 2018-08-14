package com.project.dao;

import com.project.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {
    int deleteByPrimaryKey(String teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}