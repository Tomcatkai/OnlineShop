package com.onlineshop.utils;

import java.util.UUID;

/**
 * 通用工具类
 *
 * @author kaizhang
 * @create 2018-04-07 15:31
 **/

public class CommonUtils {
    /**
     * 返回一个不重复的字符串
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
