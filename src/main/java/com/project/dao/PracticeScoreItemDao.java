package com.project.dao;

import com.project.entity.PracticeScoreItem;

public interface PracticeScoreItemDao {
    int deleteByPrimaryKey(String scoreitemId);

    int insert(PracticeScoreItem record);

    int insertSelective(PracticeScoreItem record);

    PracticeScoreItem selectByPrimaryKey(String scoreitemId);

    int updateByPrimaryKeySelective(PracticeScoreItem record);

    int updateByPrimaryKey(PracticeScoreItem record);
}