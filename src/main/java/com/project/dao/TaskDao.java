package com.project.dao;

import com.project.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}