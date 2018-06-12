package com.onlineshop.entity;

public class Cart {
    private String cartId;

    private String cartUid;

    private Integer cartBookId;

    private Integer cartBookNum;

    private double book_price_current;

    public Cart() {
    }

    public Cart(String cartId, String cartUid, Integer cartBookId, Integer cartBookNum, double book_price_current) {
        this.cartId = cartId;
        this.cartUid = cartUid;
        this.cartBookId = cartBookId;
        this.cartBookNum = cartBookNum;
        this.book_price_current = book_price_current;
    }

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

    public double getBook_price_current() {
        return book_price_current;
    }

    public void setBook_price_current(double book_price_current) {
        this.book_price_current = book_price_current;
    }
}