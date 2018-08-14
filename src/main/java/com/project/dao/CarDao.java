package com.project.dao;

import com.project.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao {
    int deleteByPrimaryKey(String carId);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carId);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
}