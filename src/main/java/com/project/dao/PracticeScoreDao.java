package com.project.dao;

import com.project.entity.PracticeScore;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeScoreDao {
    int deleteByPrimaryKey(String practiceScoreId);

    int insert(PracticeScore record);

    int insertSelective(PracticeScore record);

    PracticeScore selectByPrimaryKey(String practiceScoreId);

    int updateByPrimaryKeySelective(PracticeScore record);

    int updateByPrimaryKey(PracticeScore record);
}