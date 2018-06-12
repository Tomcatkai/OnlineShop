package com.onlineshop.vo;

import com.onlineshop.entity.Classify;

import java.util.List;

/**
 * 分类Vo
 *
 * @author kaizhang
 * @create 2018-05-09 22:53
 **/

public class ClassifyVo {
    /**
     * 分类id
     */
    private String classifyId;

    /**
     * 分类名
     */
    private String classifyName;

    private String classifyPid;

    /**
     * 子分类集合
     */
    private List<Classify> childClassify;
}
