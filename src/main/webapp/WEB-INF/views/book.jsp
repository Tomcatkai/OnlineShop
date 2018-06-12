<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/1
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>商品页面</title>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
    <link rel="stylesheet" href="../../static/css/style/common.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/base.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/global.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/header.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/goods.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/bottomnav.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/footer.css" type="text/css">

    <!--引入jqzoom css -->
    <link rel="stylesheet" href="../../static/css/style/jqzoom.css" type="text/css">
    <script type="text/javascript" src="../../static/js/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../static/js/js/header.js"></script>
    <script type="text/javascript" src="../../static/js/js/goods.js"></script>
    <script src="../../static/js/book/detail/detail.js" type="text/javascript" charset="UTF-8"></script>
    <script type="text/javascript" src="../../static/js/js/jqzoom-core.js"></script>

    <!-- jqzoom 效果 -->
    <script type="text/javascript">
        var bookId = ${book.bookId};
        $(function(){
            $('.jqzoom').jqzoom({
                zoomType: 'standard',
                lens:true,
                preloadImages: false,
                alwaysOn:false,
                title:false,
                zoomWidth:400,
                zoomHeight:400
            });
        })
    </script>
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

<!-- 头部 start -->
<div class="header w1210 bc mt15">
    <!-- 头部上半部分 start 包括 logo、搜索、用户中心和购物车结算 -->
    <div class="logo w1210">
        <h1 class="fl"><a href="index.html"><img src="../../static/img/logo-small1.png" alt="优书网"></a></h1>
        <!-- 头部搜索 start -->
        <div class="search fl">
            <div class="search_form">
                <div class="form_left fl"></div>
                <form action="${pageContext.request.contextPath}/book/queryname.html" name="serarch" method="get" class="fl">
                    <input type="text" class="txt" name="bookName" value="请输入商品关键字" /><input type="submit" class="btn" value="搜索" />
                </form>
                <div class="form_right fl"></div>
            </div>

            <div style="clear:both;"></div>

            <div class="hot_search">
                <a href="${pageContext.request.contextPath}/book/serch.html"><strong>高级搜索</strong></a>
            </div>
        </div>
        <!-- 头部搜索 end -->


        <!-- 购物车 start -->
        <div class="cart fl">
            <dl>
                <dt>
                    <a href="${pageContext.request.contextPath}/cart/detail.html">去购物车结算</a>
                </dt>
            </dl>
        </div>
        <!-- 购物车 end -->
    </div>
    <!-- 头部上半部分 end -->

    <div style="clear:both;"></div>

    <!-- 导航条部分 start -->
    <div class="nav w1210 bc mt10">

        <div class="navitems fl">
            <ul class="fl">
                <li class="current"><a href="">首页</a></li>
                <li><a href="">新书推荐</a></li>
                <li><a href="">最热图书</a></li>
                <li><a href="">网络文学</a></li>
                <li><a href="">电子书</a></li>
                <li><a href="">青春文学</a></li>
                <li><a href="">动漫</a></li>
            </ul>
            <div class="right_corner fl"></div>
        </div>
    </div>
    <!-- 导航条部分 end -->
</div>
<!-- 头部 end-->

<div style="clear:both;"></div>


<!-- 商品页面主体 start -->
<div class="main w1210 mt10 bc">
    <!-- 面包屑导航 start -->
    <div class="breadcrumb">
        <h2>当前位置：<a href="">首页</a> > <a href="">图书详情</a></h2>
    </div>
    <!-- 面包屑导航 end -->

    <!-- 商品信息内容 start -->
    <div class="goods_content fl mt10 ml10">
        <!-- 商品概要信息 start -->
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
                                    <sapn id="InitCartUrl" class="btn-special1 btn-lg" style="color: #fff">加入购物车</sapn>
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
        <!-- 商品概要信息 end -->

        <div style="clear:both;"></div>

    </div>
    <!-- 商品信息内容 end -->


</div>
<!-- 商品页面主体 end -->


<div style="clear:both;"></div>

<!-- 底部导航 start -->
<div class="bottomnav w1210 bc mt10">
    <div class="bnav1">
        <h3><b></b> <em>购物指南</em></h3>
        <ul>
            <li><a href="">购物流程</a></li>
            <li><a href="">会员介绍</a></li>
            <li><a href="">团购/机票/充值/点卡</a></li>
            <li><a href="">常见问题</a></li>
            <li><a href="">大家电</a></li>
            <li><a href="">联系客服</a></li>
        </ul>
    </div>

    <div class="bnav2">
        <h3><b></b> <em>配送方式</em></h3>
        <ul>
            <li><a href="">上门自提</a></li>
            <li><a href="">快速运输</a></li>
            <li><a href="">特快专递（EMS）</a></li>
            <li><a href="">如何送礼</a></li>
            <li><a href="">海外购物</a></li>
        </ul>
    </div>


    <div class="bnav3">
        <h3><b></b> <em>支付方式</em></h3>
        <ul>
            <li><a href="">货到付款</a></li>
            <li><a href="">在线支付</a></li>
            <li><a href="">分期付款</a></li>
            <li><a href="">邮局汇款</a></li>
            <li><a href="">公司转账</a></li>
        </ul>
    </div>

    <div class="bnav4">
        <h3><b></b> <em>售后服务</em></h3>
        <ul>
            <li><a href="">退换货政策</a></li>
            <li><a href="">退换货流程</a></li>
            <li><a href="">价格保护</a></li>
            <li><a href="">退款说明</a></li>
            <li><a href="">返修/退换货</a></li>
            <li><a href="">退款申请</a></li>
        </ul>
    </div>

    <div class="bnav5">
        <h3><b></b> <em>特色服务</em></h3>
        <ul>
            <li><a href="">夺宝岛</a></li>
            <li><a href="">DIY装机</a></li>
            <li><a href="">延保服务</a></li>
            <li><a href="">家电下乡</a></li>
            <li><a href="">京东礼品卡</a></li>
            <li><a href="">能效补贴</a></li>
        </ul>
    </div>
</div>
<!-- 底部导航 end -->

<div style="clear:both;"></div>
<!-- 底部版权 start -->
<div class="footer w1210 bc mt10">
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
        © 2005-2013 京东网上商城 版权所有，并保留所有权利。  ICP备案证书号:京ICP证070359号
    </p>
    <p class="auth">
        <a href=""><img src="../../static/img/images/xin.png" alt="" /></a>
        <a href=""><img src="../../static/img/images/kexin.jpg" alt="" /></a>
        <a href=""><img src="../../static/img/images/police.jpg" alt="" /></a>
        <a href=""><img src="../../static/img/images/beian.gif" alt="" /></a>
    </p>
</div>
<!-- 底部版权 end -->

<script type="text/javascript">
    document.execCommand("BackgroundImageCache", false, true);
</script>
</body>
</html>