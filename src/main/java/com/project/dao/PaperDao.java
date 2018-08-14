package com.project.dao;

import com.project.entity.Paper;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperDao {
    int deleteByPrimaryKey(String paperId);

    int insert(Paper record);

    int insertSelective(Paper record);

    Paper selectByPrimaryKey(String paperId);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);
}