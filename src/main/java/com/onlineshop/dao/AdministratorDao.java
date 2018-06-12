package com.onlineshop.dao;

import com.onlineshop.entity.Administrator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorDao {
    int deleteByPrimaryKey(String adminId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(String adminId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    int selectAdminByPassAndName(@Param("adminName")String adminName, @Param("adminPass")String adminPass);
}