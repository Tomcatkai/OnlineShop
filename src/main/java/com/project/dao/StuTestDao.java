package com.project.dao;

import com.project.entity.StuTest;
import org.springframework.stereotype.Repository;

@Repository
public interface StuTestDao {
    int deleteByPrimaryKey(String stuTestId);

    int insert(StuTest record);

    int insertSelective(StuTest record);

    StuTest selectByPrimaryKey(String stuTestId);

    int updateByPrimaryKeySelective(StuTest record);

    int updateByPrimaryKey(StuTest record);
}