package com.onlineshop.dao;

import com.onlineshop.entity.Classify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyDao {
    int deleteByPrimaryKey(String classifyId);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(String classifyId);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);

    /**
     * 查询所有父分类
     * @return
     */
    List<Classify> selectParentClassifys();

    /**
     * 统计所有父分类总数
     * @return
     */
    int countAllParentClassifys();

    /**
     * 查询父分类下的所有子分类
     * @param pid
     * @return
     */
    List<Classify> selectChildClassifys(String pid);

    /**
     * 查询某一分类下子分类的个数
     * @param classifyId
     * @return
     */
    int countChildClassifyNum(String classifyId);

    /**
     * 查询所有子分类
     */
    List<Classify> selectAllChildClassifys();

    /**
     * 统计所有子分类数量
     * @return
     */
    int countAllChildClassifys();


}