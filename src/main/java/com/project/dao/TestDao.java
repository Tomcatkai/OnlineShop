package com.project.dao;

import com.project.entity.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
    int deleteByPrimaryKey(String testId);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(String testId);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}