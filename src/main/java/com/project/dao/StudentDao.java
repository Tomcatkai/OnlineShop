package com.project.dao;

import com.project.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    int deleteByPrimaryKey(String stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}