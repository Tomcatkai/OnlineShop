<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/4/10
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="../../../static/css/book/detail/initialize.css">
    <link rel="stylesheet" href="../../../static/lib/layui/css/layui.css">
    <link rel="stylesheet" href="../../../static/css/cart.css"/>
    <script type="text/javascript" src="../../../static/js/cart/cart.js"></script>
</head>
<body>

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
<div class="content-wrapper">
        <table id="cartTable">
            <thead>
            <tr>
                <th><label><input class="check-all check" type="checkbox"/>&nbsp;全选</label></th>
                <th>商品</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${cartItems}">
                <tr>
                    <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
                    <td class="goods"><img class="img" src="${item.bookPicBig}" alt=""/><span>${item.bookName}</span></td>
                    <td class="price">${item.bookPriceCurrent}</td>
                    <td class="count">
                        <span class="reduce"></span>
                        <input class="count-input" type="text" value="${item.cartBookNum}"/>
                        <span class="add">+</span></td>
                    <td class="subtotal">5999.88</td>
                    <td class="operation"><span class="delete">删除</span></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    <div class="foot" id="foot">
        <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;全选</label>
        <a class="fl delete" id="deleteAll" href="javascript:;">删除</a>
        <div class="fr closing">结 算</div>
        <div class="fr total">合计：￥<span id="priceTotal">0.00</span></div>
        <div class="fr selected" id="selected">已选商品
            <span id="selectedTotal">0</span>件
            <span class="arrow up">︽</span>
            <span class="arrow down">︾</span>
        </div>
        <div class="selected-view">
            <div id="selectedViewList" class="clearfix">
                <!--<div><img src="images/1.jpg"><span>取消选择</span></div>-->
            </div>
            <span class="arrow">◆<span>◆</span></span>
        </div>
    </div>
</div>

<div class="bottom-wrapper">
    <hr/>
    <div class="layui-footer">
        版权所有 © 1995-2018，优书网
    </div>
</div>
</body>
</html>