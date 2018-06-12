package com.onlineshop.entity;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookSubhead;

    private String bookAuthor;

    private String bookPublisher;

    private Double bookPriceFormer;

    private Double bookPriceCurrent;

    private Double bookDiscount;

    private String bookDescription;

    private Date bookPublishTime;

    private String bookTranslator;

    private String bookPicSmall;

    private String bookPicBig;

    private String bookClassifyId;

    private Date bookPressTime;

    private String bookIsbn;

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
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookSubhead() {
        return bookSubhead;
    }

    public void setBookSubhead(String bookSubhead) {
        this.bookSubhead = bookSubhead == null ? null : bookSubhead.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher == null ? null : bookPublisher.trim();
    }

    public Double getBookPriceFormer() {
        return bookPriceFormer;
    }

    public void setBookPriceFormer(Double bookPriceFormer) {
        this.bookPriceFormer = bookPriceFormer;
    }

    public Double getBookPriceCurrent() {
        return bookPriceCurrent;
    }

    public void setBookPriceCurrent(Double bookPriceCurrent) {
        this.bookPriceCurrent = bookPriceCurrent;
    }

    public Double getBookDiscount() {
        return bookDiscount;
    }

    public void setBookDiscount(Double bookDiscount) {
        this.bookDiscount = bookDiscount;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription == null ? null : bookDescription.trim();
    }

    public Date getBookPublishTime() {
        return bookPublishTime;
    }

    public void setBookPublishTime(Date bookPublishTime) {
        this.bookPublishTime = bookPublishTime;
    }

    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator == null ? null : bookTranslator.trim();
    }

    public String getBookPicSmall() {
        return bookPicSmall;
    }

    public void setBookPicSmall(String bookPicSmall) {
        this.bookPicSmall = bookPicSmall == null ? null : bookPicSmall.trim();
    }

    public String getBookPicBig() {
        return bookPicBig;
    }

    public void setBookPicBig(String bookPicBig) {
        this.bookPicBig = bookPicBig == null ? null : bookPicBig.trim();
    }

    public String getBookClassifyId() {
        return bookClassifyId;
    }

    public void setBookClassifyId(String bookClassifyId) {
        this.bookClassifyId = bookClassifyId == null ? null : bookClassifyId.trim();
    }

    public Date getBookPressTime() {
        return bookPressTime;
    }

    public void setBookPressTime(Date bookPressTime) {
        this.bookPressTime = bookPressTime;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn == null ? null : bookIsbn.trim();
    }
}