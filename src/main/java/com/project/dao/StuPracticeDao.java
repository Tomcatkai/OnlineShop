package com.project.dao;

import com.project.entity.StuPractice;

public interface StuPracticeDao {
    int deleteByPrimaryKey(String stuPracticeId);

    int insert(StuPractice record);

    int insertSelective(StuPractice record);

    StuPractice selectByPrimaryKey(String stuPracticeId);

    int updateByPrimaryKeySelective(StuPractice record);

    int updateByPrimaryKey(StuPractice record);
}