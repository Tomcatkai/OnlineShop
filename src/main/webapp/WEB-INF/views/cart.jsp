<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/3
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>购物车页面</title>
    <link rel="stylesheet" href="../../static/css/style/base.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/global.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/header.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/cart.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/footer.css" type="text/css">

    <script type="text/javascript" src="../../static/js/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../static/js/js/cart1.js"></script>

</head>
<body>
<!-- 顶部导航 start -->
<div class="topnav">
    <div class="topnav_bd w1210 bc">
        <div class="topnav_left">

        </div>
        <div class="topnav_right fr">
            <ul>
                <c:if test="">

                </c:if>
                <c:choose>
                    <c:when test="${!empty sessionScope.userName}">
                        <li>${sessionScope.userName}，欢迎您！[<a href="${pageContext.request.contextPath}/user/logout.html">退出登录</a>] </li>
                        <li class="line">|</li>
                        <li><a href="${pageContext.request.contextPath}/order/detail.html">我的订单</a></li>
                    </c:when>
                    <c:otherwise>
                        <li>您好，欢迎来到优书网！[<a href="${pageContext.request.contextPath}/user/loginPage.html">登录</a>] [<a href="${pageContext.request.contextPath}/user/register.html">免费注册</a>] </li>
                    </c:otherwise>
                </c:choose>

                <li class="line">|</li>
                <li>客户服务</li>

            </ul>
        </div>
    </div>
</div>
<!-- 顶部导航 end -->

<div style="clear:both;"></div>

<!-- 页面头部 start -->
<div class="header w990 bc mt15">
    <div class="logo w990">
        <h2 class="fl"><a href="index.html"><img src="../../static/img/logo-small1.png" alt="优书网"></a></h2>
        <div class="flow fr">
            <ul>
                <li class="cur">1.我的购物车</li>
                <li>2.填写核对订单信息</li>
                <li>3.成功提交订单</li>
            </ul>
        </div>
    </div>
</div>
<!-- 页面头部 end -->

<div style="clear:both;"></div>

<!-- 主体部分 start -->
<div class="mycart w990 mt10 bc">
    <h2><span>我的购物车</span></h2>
    <table>
        <thead>
        <tr>
            <th class="col1">商品名称</th>
            <th class="col2">
                <%--商品信息--%>
            </th>
            <th class="col3">单价</th>
            <th class="col4">数量</th>
            <th class="col5">小计</th>
            <th class="col6">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cartVo.cartItemDtos}">
            <tr>
                <td class="col1"><a href=""><img src="${item.bookPicBig}" alt=""/></a> <strong><a
                        href="">${item.bookName}</a></strong></td>
                <td class="col2">
                    <%--<p>颜色：073深红</p>--%>
                    <%--<p>尺码：170/92A/S</p>--%>
                </td>
                <td class="col3">￥<span>${item.bookPriceCurrent}</span></td>
                <td class="col4">
                    <a href="/cart/change/${item.cartBookId}.html?flag=false" class="reduce_num"></a>
                    <input type="text" name="amount" value="${item.cartBookNum}" class="amount"/>
                    <a href="/cart/change/${item.cartBookId}.html?flag=true" class="add_num"></a>
                </td>
                <td class="col5">￥<span>${item.colSubTotal}</span></td>
                <td class="col6"><a href="${pageContext.request.contextPath}/cart/delete/${item.cartBookId}.html">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="6">购物金额总计： <strong>￥ <span id="total">${cartVo.allSubTotal}</span></strong></td>
        </tr>
        </tfoot>
    </table>
    <div class="cart_btn w990 bc mt10">
        <a href="${pageContext.request.contextPath}/index.html" class="continue">继续购物</a>
        <a href="${pageContext.request.contextPath}/order/check.html" class="checkout">结 算</a>
    </div>
</div>
<!-- 主体部分 end -->

<div style="clear:both;"></div>
<!-- 底部版权 start -->
<div class="footer w1210 bc mt15">
    <p class="links">
        <a href="">关于我们</a> |
        <a href="">联系我们</a> |
        <a href="">人才招聘</a> |
        <a href="">商家入驻</a> |
        <a href="">千寻网</a> |
        <a href="">奢侈品网</a> |
        <a href="">广告服务</a> |
        <a href="">移动终端</a> |
        <a href="">友情链接</a> |
        <a href="">销售联盟</a> |
        <a href="">京西论坛</a>
    </p>
    <p class="copyright">
        © 2005-2013 京东网上商城 版权所有，并保留所有权利。 ICP备案证书号:京ICP证070359号
    </p>
    <p class="auth">
        <a href=""><img src="../../static/img/images/xin.png" alt=""/></a>
        <a href=""><img src="../../static/img/images/kexin.jpg" alt=""/></a>
        <a href=""><img src="../../static/img/images/police.jpg" alt=""/></a>
        <a href=""><img src="../../static/img/images/beian.gif" alt=""/></a>
    </p>
</div>
<!-- 底部版权 end -->
</body>
</html>