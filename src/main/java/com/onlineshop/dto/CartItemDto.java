package com.onlineshop.dto;

import java.math.BigDecimal;

/**
 * 购物车条目数据传输对象
 *
 * @author kaizhang
 * @create 2018-05-01 15:55
 **/

public class CartItemDto {

    private String cartId;

    private String cartUid;

    private Integer cartBookId;

    private Integer cartBookNum;

    private double bookPriceCurrent;

    private String bookName;

    private String bookPicBig;

    private BigDecimal colSubTotal;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCartUid() {
        return cartUid;
    }

    public void setCartUid(String cartUid) {
        this.cartUid = cartUid;
    }

    public Integer getCartBookId() {
        return cartBookId;
    }

    public void setCartBookId(Integer cartBookId) {
        this.cartBookId = cartBookId;
    }

    public Integer getCartBookNum() {
        return cartBookNum;
    }

    public void setCartBookNum(Integer cartBookNum) {
        this.cartBookNum = cartBookNum;
    }

    public double getBookPriceCurrent() {
        return bookPriceCurrent;
    }

    public void setBookPriceCurrent(double bookPriceCurrent) {
        this.bookPriceCurrent = bookPriceCurrent;
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

    public BigDecimal getColSubTotal() {
        return colSubTotal;
    }

    public void setColSubTotal(BigDecimal colSubTotal) {
        this.colSubTotal = colSubTotal;
    }

    public CartItemDto() {
    }

    public CartItemDto(String cartId, String cartUid, Integer cartBookId, Integer cartBookNum, double bookPriceCurrent, String bookName, String bookPicBig, BigDecimal colSubTotal) {
        this.cartId = cartId;
        this.cartUid = cartUid;
        this.cartBookId = cartBookId;
        this.cartBookNum = cartBookNum;
        this.bookPriceCurrent = bookPriceCurrent;
        this.bookName = bookName;
        this.bookPicBig = bookPicBig;
        this.colSubTotal = colSubTotal;
    }
}
