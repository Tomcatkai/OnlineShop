package com.project.dao;

import com.project.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    int deleteByPrimaryKey(String adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}