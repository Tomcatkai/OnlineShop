package com.onlineshop.service;

import com.github.pagehelper.PageHelper;
import com.onlineshop.dao.ClassifyDao;
import com.onlineshop.entity.Classify;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书分类相关业务
 *
 * @author kaizhang
 * @create 2018-04-27 18:53
 **/
@Service
public class ClassifyService {

    @Autowired
    ClassifyDao classifyDao;

    /**
     * 返回所有父分类及其下的子分类
     *
     * @return
     */
    public List<Classify> selectAllClassifys() {
        List<Classify> parentClassifys = classifyDao.selectParentClassifys();
        for (Classify classifyp : parentClassifys) {
            classifyp.setChildClassify(classifyDao.selectChildClassifys(classifyp.getClassifyId()));
        }
        return parentClassifys;
    }

    /**
     * 新增分类
     *
     * @param classify 要新增的分类对象
     * @return
     */
    public int insertNewClassify(Classify classify) {
        return classifyDao.insert(classify);
    }

    /**
     * 删除分类     有子分类的父分类不予删除
     *
     * @param classifyId
     * @return
     */
    public int deleteClassify(String classifyId) {
        if (StringUtils.isNotEmpty(classifyId)) {
            if (classifyDao.countChildClassifyNum(classifyId) == 0) {
                return classifyDao.deleteByPrimaryKey(classifyId);
            }
        }
        return 0;
    }

    /**
     * 修改分类
     *
     * @param classify
     * @return
     */
    public int updateClassify(Classify classify) {
        return classifyDao.updateByPrimaryKeySelective(classify);
    }

    /**
     * 返回所有父分类list
     *
     * @return
     */
    public List<Classify> selectClassifyParent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        return classifyDao.selectParentClassifys();
    }

    /**
     * 查询所有子分类
     *
     * @return
     */
    public List<Classify> selectAllChildClassifys(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        return classifyDao.selectAllChildClassifys();
    }

    /**
     * 统计父分类数量
     *
     * @return
     */
    public int countClassifyP() {
        return classifyDao.countAllParentClassifys();
    }

    /**
     * 统计子分类数量
     *
     * @return
     */
    public int countClassifyC() {
        return classifyDao.countAllChildClassifys();
    }

}
