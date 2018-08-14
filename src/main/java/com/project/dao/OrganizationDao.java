package com.project.dao;

import com.project.entity.Organization;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDao {
    int deleteByPrimaryKey(String orgId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String orgId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}