package com.project.dao;

import com.project.entity.Score;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDao {
    int deleteByPrimaryKey(String scoreId);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(String scoreId);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);
}