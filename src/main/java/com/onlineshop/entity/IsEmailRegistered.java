package com.onlineshop.entity;

import javax.xml.bind.annotation.*;

/**
 * json对应对象
 *
 * @author kaizhang
 * @create 2018-04-05 21:00
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"isEmailRegistered"})
public class IsEmailRegistered {
    @XmlAttribute(name = "isEmailRegistered")
    private boolean isEmailRegistered;

    public boolean getIsEmailRegistered() {
        return isEmailRegistered;
    }

    public void setIsEmailRegistered(boolean isEmailRegistered) {
        this.isEmailRegistered = isEmailRegistered;
    }

    public IsEmailRegistered(boolean isEmailRegistered) {
        this.isEmailRegistered = isEmailRegistered;
    }

    public IsEmailRegistered() {
    }
}
