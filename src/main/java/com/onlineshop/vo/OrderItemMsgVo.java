package com.onlineshop.vo;

import java.math.BigDecimal;

/**
 * 订单条目信息vo
 *
 * @author kaizhang
 * @create 2018-05-10 16:55
 **/

public class OrderItemMsgVo {

    private String orderItemId;

    private Integer bookNum;

    private Integer bookId;

    private String bookName;

    private String bookPicBig;

    private Double bookPriceCurrent;

    private BigDecimal totalPrice;

    public OrderItemMsgVo() {
    }

    public OrderItemMsgVo(String orderItemId, Integer bookNum, Integer bookId, String bookName, String bookPicBig, Double bookPriceCurrent, BigDecimal totalPrice) {
        this.orderItemId = orderItemId;
        this.bookNum = bookNum;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPicBig = bookPicBig;
        this.bookPriceCurrent = bookPriceCurrent;
        this.totalPrice = totalPrice;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPicBig() {
        return bookPicBig;
    }

    public void setBookPicBig(String bookPicBig) {
        this.bookPicBig = bookPicBig;
    }

    public Double getBookPriceCurrent() {
        return bookPriceCurrent;
    }

    public void setBookPriceCurrent(Double bookPriceCurrent) {
        this.bookPriceCurrent = bookPriceCurrent;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
