package com.project.dao;

import com.project.entity.ScoreItem;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreItemDao {
    int deleteByPrimaryKey(String scoreitemId);

    int insert(ScoreItem record);

    int insertSelective(ScoreItem record);

    ScoreItem selectByPrimaryKey(String scoreitemId);

    int updateByPrimaryKeySelective(ScoreItem record);

    int updateByPrimaryKey(ScoreItem record);
}