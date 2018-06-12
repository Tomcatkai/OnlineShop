package com.onlineshop.entity;

public class Address {
    private String addressId;

    private String addressUid;

    private Integer addressStatus;

    private String addressReceiver;

    private String addressReceiverPhone;

    private String addressDetail;

    private String addressProvince;

    private String addressCity;

    private String addressArea;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getAddressUid() {
        return addressUid;
    }

    public void setAddressUid(String addressUid) {
        this.addressUid = addressUid == null ? null : addressUid.trim();
    }

    public Integer getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(Integer addressStatus) {
        this.addressStatus = addressStatus;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver == null ? null : addressReceiver.trim();
    }

    public String getAddressReceiverPhone() {
        return addressReceiverPhone;
    }

    public void setAddressReceiverPhone(String addressReceiverPhone) {
        this.addressReceiverPhone = addressReceiverPhone == null ? null : addressReceiverPhone.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea == null ? null : addressArea.trim();
    }
}