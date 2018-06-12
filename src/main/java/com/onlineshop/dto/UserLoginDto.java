package com.onlineshop.dto;

import com.onlineshop.entity.User;

/**
 * 用户登录dto
 *
 * @author kaizhang
 * @create 2018-05-01 19:29
 **/

public class UserLoginDto {
    /**
     * 返回给前端的提示信息
     */
    private String msg;

    /**
     * 返回给前端的用户对象
     */
    private User user;

    public UserLoginDto() {
    }

    public UserLoginDto(String msg, User user) {
        this.msg = msg;
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
