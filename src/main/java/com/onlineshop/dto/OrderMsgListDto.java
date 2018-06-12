package com.onlineshop.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息列表,管理员用
 *
 * @author kaizhang
 * @create 2018-05-09 14:52
 **/

public class OrderMsgListDto {

private String orderId;
private Date orderTime;
private BigDecimal orderTotal;
private Integer orderStatus;
private String addressReceiver;
private String addressReceiverPhone;
private String addressDetail;
private String addressProvince;
private String addressCity;
private String addressArea;
private String loginName;

    public OrderMsgListDto() {
    }

    public OrderMsgListDto(String orderId, Date orderTime, BigDecimal orderTotal, Integer orderStatus, String addressReceiver, String addressReceiverPhone, String addressDetail, String addressProvince, String addressCity, String addressArea, String loginName) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.addressReceiver = addressReceiver;
        this.addressReceiverPhone = addressReceiverPhone;
        this.addressDetail = addressDetail;
        this.addressProvince = addressProvince;
        this.addressCity = addressCity;
        this.addressArea = addressArea;
        this.loginName = loginName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver;
    }

    public String getAddressReceiverPhone() {
        return addressReceiverPhone;
    }

    public void setAddressReceiverPhone(String addressReceiverPhone) {
        this.addressReceiverPhone = addressReceiverPhone;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
