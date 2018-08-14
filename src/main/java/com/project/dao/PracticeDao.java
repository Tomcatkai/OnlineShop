package com.project.dao;

import com.project.entity.Practice;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeDao {
    int deleteByPrimaryKey(String practiceId);

    int insert(Practice record);

    int insertSelective(Practice record);

    Practice selectByPrimaryKey(String practiceId);

    int updateByPrimaryKeySelective(Practice record);

    int updateByPrimaryKey(Practice record);
}