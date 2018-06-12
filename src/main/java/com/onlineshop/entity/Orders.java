package com.onlineshop.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private String orderId;

    private Date orderTime;

    private BigDecimal orderTotal;

    private Integer orderStatus;

    private String orderUid;

    private String orderAdressId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUid() {
        return orderUid;
    }

    public void setOrderUid(String orderUid) {
        this.orderUid = orderUid == null ? null : orderUid.trim();
    }

    public String getOrderAdressId() {
        return orderAdressId;
    }

    public void setOrderAdressId(String orderAdressId) {
        this.orderAdressId = orderAdressId == null ? null : orderAdressId.trim();
    }
}