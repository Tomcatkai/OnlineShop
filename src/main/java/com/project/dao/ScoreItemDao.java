package com.project.dao;

import com.project.entity.ScoreItem;

public interface ScoreItemDao {
    int deleteByPrimaryKey(String scoreitemId);

    int insert(ScoreItem record);

    int insertSelective(ScoreItem record);

    ScoreItem selectByPrimaryKey(String scoreitemId);

    int updateByPrimaryKeySelective(ScoreItem record);

    int updateByPrimaryKey(ScoreItem record);
}