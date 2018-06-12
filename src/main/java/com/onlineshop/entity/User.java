package com.onlineshop.entity;

/**
 * 用户类
 *
 * @author kaizhang
 * @create 2018-03-25 23:42
 **/

public class User {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 登录名
     */
    private String loginName;
    /**
     *登录密码
     */
    private String loginPass;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户激活状态
     */
    private boolean status;
    /**
     * 激活码
     */
    private String activationCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public User() {
    }

    public User(String userId, String loginName, String loginPass, String email, boolean status, String activationCode) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.email = email;
        this.status = status;
        this.activationCode = activationCode;
    }
}
