package com.onlineshop.entity;

public class Administrator {
    private String adminId;

    private String adminLoginName;

    private String adminLoginPass;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName == null ? null : adminLoginName.trim();
    }

    public String getAdminLoginPass() {
        return adminLoginPass;
    }

    public void setAdminLoginPass(String adminLoginPass) {
        this.adminLoginPass = adminLoginPass == null ? null : adminLoginPass.trim();
    }
}