package com.onlineshop.dto;

/**
 * 订单条目dto
 *
 * @author kaizhang
 * @create 2018-05-10 16:31
 **/

public class OrderItemMsgDto {

    private String orderItemId;

    private Integer bookNum;

    private Integer bookId;

    private String bookName;

    private String bookPicBig;

    private Double bookPriceCurrent;

    public OrderItemMsgDto() {
    }

    public OrderItemMsgDto(String orderItemId, Integer bookNum, Integer bookId, String bookName, String bookPicBig, Double bookPriceCurrent) {
        this.orderItemId = orderItemId;
        this.bookNum = bookNum;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPicBig = bookPicBig;
        this.bookPriceCurrent = bookPriceCurrent;
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
}
