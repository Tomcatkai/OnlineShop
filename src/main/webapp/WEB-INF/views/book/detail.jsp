<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/4/12
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书详情页</title>
</head>
<link rel="stylesheet" href="../../../static/css/book/detail/initialize.css">
<link rel="stylesheet" href="../../../static/lib/layui/css/layui.css">
<link rel="stylesheet" href="../../../static/css/book/detail/detail.css">
<body>
<div class="all-wrapper">
    <div class="top-wrapper">
        <div id="topWrap">
            <div class="top">
                <div class="top_left f-fl">
                    <span class="sc"><a href="#">设为首页</a></span>
                    <span class="adress"><a href="#">收藏本站</a></span>
                </div>
                <div class="top_right f-fr">
                    <ul>
                        <li>优书网，欢迎来到优书网</li>
                        <li><a href="">[登录]</a></li>
                        <li><a href="">[免费注册]</a></li>
                        <li><a href="#">|</a></li>
                        <li class="vip"><a href="#">会员中心</a></li>
                        <li><a href="#">|</a></li>
                        <li><a href="">我的订单</a></li>
                        <li><a href="#">|</a></li>
                        <li><a href="#">我的收藏</a></li>
                        <li><a href="#">|</a></li>
                        <li class="nomg"><a href="#">客服服务</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="header">
            <div class="logo"><a href="#"><img id="ourlogo" src="../../../static/img/book/detail/logo-small1.png"
                                               alt="logo"/></a></div>
            <div class="searchAndlist">
                <div class="search">
                    <form name="search_top" action="" method="get" id="form1">
                        <input type="hidden" name="method" value="findByBname"/>

                        <input type="text" class="txt" placeholder="输入书名进行搜索" name="bname"/>


                        <a href="javascript:document.getElementById('form1').submit();"><input type="button"
                                                                                               class="sub"/></a>
                        <a href="" style="font-size: 10pt; color: #404040;">高级搜索</a>
                    </form>
                </div>
                <div class="cl"></div>
                <ul class="list">
                    <li>热门搜索 :</li>
                    <li class="first"><a href="">Java编程思想</a></li>
                    <li><a href="#"> </a></li>
                    <li><a href="">Java核心技术</a></li>
                    <li><a href="">php从入门到精通</a></li>
                </ul>
            </div>
            <ul class="buy">
                <li class="accounts">
                    <a href="">去购物结算</a>
                    <span class="num">0</span>
                </li>
            </ul>
            <div class="cl"></div>
        </div>
    </div>
    <hr/>
    <c:choose>
        <c:when test="${not empty book}">
            <div class="content-wrapper">
                <div class="sale-content">
                    <div class="pic-info">
                        <img src="${book.bookPicBig}"/>
                    </div>
                    <div class="sale-box">
                        <div class="title"><h1 title="${book.bookName}">${book.bookName}</h1></div>
                        <div class="description"><h2 title="${book.bookSubhead}">${book.bookSubhead}</h2></div>
                        <div class="book-msg">
                    <span class="author" id="author">
                        作者:${book.bookAuthor}
                    </span>
                            <span class="press">
                        出品出版社: ${book.bookPublisher}
                    </span>
                            <span class="publish-time">
                        出版时间:${book.bookPublishTime}
                    </span>
                        </div>
                        <div class="price clearfix">
                            <div class="price_d">
                                <p class="price-content price-label">
                                    优书价
                                </p>
                                <p class="price-content current">
                                    <span class="yen">¥</span>
                                        ${book.bookPriceCurrent}
                                </p>
                            </div>
                            <div class="price-content discount">
                                (${book.bookDiscount}折)
                            </div>
                            <div class="price-content former-price-label">
                                定价
                            </div>
                            <div class="price-content former">
                                <span class="yen">¥</span>
                                    ${book.bookPriceFormer}
                            </div>
                        </div>
                        <div class="choose-btns">
                            <div class="choose-amount">
                                <div class="wrap-input">
                                    <input class="text buy-num" id="buy-num" value="1"/>
                                    <a class="btn-reduce" href="#none">-</a>
                                    <a class="btn-add" href="#none">+</a>
                                </div>
                            </div>
                            <a href="#" id="InitCartUrl" class="btn-special1 btn-lg">加入购物车</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="content-wrapper" style="text-align: center; margin-top: 200px">
                    <h1>您要查询的图书信息已不存在，请重新查询，谢谢！</h1>
            </div>
        </c:otherwise>
    </c:choose>
    <hr/>
    <div class="bottom-wrapper">
        <div class="layui-footer">
            版权所有 © 1995-2018，优书网
        </div>
    </div>
</div>
<script src="../../../static/lib/jquery-3.3.1.min.js"></script>
<script src="../../../static/lib/layui/layui.js"></script>
<script src="../../../static/js/book/detail/detail.js" type="text/javascript" charset="UTF-8"></script>
</body>
</html>
