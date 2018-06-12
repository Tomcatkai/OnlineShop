<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>优书网</title>
    <link rel="Shortcut Icon" href="../../static/img/faction.png"/>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/index/brands.css"/>
    <!--新引入样式-->
    <link rel="stylesheet" href="../../static/css/style/common.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/base.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/global.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/header.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/bottomnav.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/footer.css" type="text/css">
    <!--引入jqzoom css -->
    <link rel="stylesheet" href="../../static/css/style/jqzoom.css" type="text/css">
    <script type="text/javascript" src="../../static/js/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../static/js/js/header.js"></script>
    <script type="text/javascript" src="../../static/js/js/jqzoom-core.js"></script>
    <!--页面原有样式-->
    <script src="../../static/lib/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="../../static/lib/layui/layui.js" type="text/javascript"></script>
    <script src="../../static/js/index.js" type="text/javascript"></script>
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




<div class="brands">
    <div class="br-nav">
        <div class="mt">
            <h2>图书分类</h2>
        </div>
        <c:forEach var="classifyp" items="${classifies}">
        <div class="mc">
            <div class="item">
                <a class="lab" href="${pageContext.request.contextPath}/book/queryclassify.html?classify=${classifyp.classifyId}"> <c:out value="${classifyp.classifyName}"/></a>
                <div class="item-down">
                    <ul>
                        <c:forEach var="classify" items="${classifyp.childClassify}">
                            <li><a href="${pageContext.request.contextPath}/book/queryclassify.html?classify=${classify.classifyId}"><c:out value="${classify.classifyName}"/></a></li>
                        </c:forEach>
                    </ul>
                    <div class="more" id="more-first">
                        <a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=机械工业出版社" target="_blank"><img src="../../static/img/index/brands2.jpg" alt="图片"/></a>
                        <a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=电子工业出版社" target="_blank"><img src="../../static/img/index/brands5.jpg" alt="图片"/></a>
                        <a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=人民邮电出版社" target="_blank"><img src="../../static/img/index/brands4.jpg" alt="图片"/></a>
                        <a class="mor" href="#">更多品牌</a>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <div id="brands-in" class="brands-in">
        <ul>
            <!-- method :findByCombination    /BookServlet press="qinghua" -->
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=清华大学出版社"><img src="../../static/img/index/brands1.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=机械工业出版社"><img src="../../static/img/index/brands2.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=科学出版社"><img src="../../static/img/index/brands3.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=人民邮电出版社"><img src="../../static/img/index/brands4.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=电子工业出版社"><img src="../../static/img/index/brands5.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=O'Reilly"><img src="../../static/img/index/brands6.png"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=O'Reilly"><img src="../../static/img/index/brands6.png"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=电子工业出版社"><img src="../../static/img/index/brands5.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=人民邮电出版社"><img src="../../static/img/index/brands4.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=科学出版社"><img src="../../static/img/index/brands3.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=机械工业出版社"><img src="../../static/img/index/brands2.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=清华大学出版社"><img src="../../static/img/index/brands1.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=清华大学出版社"><img src="../../static/img/index/brands1.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=机械工业出版社"><img src="../../static/img/index/brands2.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=科学出版社"><img src="../../static/img/index/brands3.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=人民邮电出版社"><img src="../../static/img/index/brands4.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=电子工业出版社"><img src="../../static/img/index/brands5.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=O'Reilly"><img src="../../static/img/index/brands6.png"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=清华大学出版社"><img src="../../static/img/index/brands1.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=机械工业出版社"><img src="../../static/img/index/brands2.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=科学出版社"><img src="../../static/img/index/brands3.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=人民邮电出版社"><img src="../../static/img/index/brands4.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=电子工业出版社"><img src="../../static/img/index/brands5.jpg"></a></li>
            <li><a href="${pageContext.request.contextPath}/book/querypublisher.html?publisher=O'Reilly"><img src="../../static/img/index/brands6.png"></a></li>
        </ul>
    </div>
</div>
<div class="cl"></div>
<div id="banner" class="banner">
    <ul>
        <li><a href=""><img src="../../static/img/index/banner-1.jpg"></a></li>
        <li><a href=""><img src="../../static/img/index/banner-2.jpg"></a></li>
        <li><a href=""><img src="../../static/img/index/banner-3.jpg"></a></li>
        <li><a href=""><img src="../../static/img/index/banner-2.jpg"></a></li>
        <li><a href=""><img src="../../static/img/index/banner-1.jpg"></a></li>
    </ul>
    <ol>
        <li class="current"></li>
        <li></li>
        <li></li>
        <li></li>
    </ol>
</div>
<div class="cl"></div>
<div id="search" class="hd-search">
    <div class="hd-bg fl"></div>
    <dl class="fl">
        <dt><label>排列：</label></dt>
        <dd><a class="current zh" href="#">综合</a></dd>
        <dd><a class="gzd" href="#">关注度</a></dd>
        <dd><a class="rq" href="#">人气</a></dd>
        <dd><a class="xl" href="#">销量</a></dd>
        <dd class="zx"><a class="zxhd" href="#">最新活动</a></dd>
    </dl>
</div>
<div class="bigbox">
    <ul id="book-list">
    </ul>
    <div class="cl"></div>
    <div id="mui-page" class="mui-page"></div>
</div>
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
            <li><a href="">优书礼品卡</a></li>
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
        <a href="">优书论坛</a>
    </p>
    <p class="copyright">
        © 2015-2018 优书网 版权所有，并保留所有权利。  ICP备案证书号:京ICP证070359号
    </p>
    <p class="auth">
        <a href=""><img src="../../static/img/images/xin.png" alt="" /></a>
        <a href=""><img src="../../static/img/images/kexin.jpg" alt="" /></a>
        <a href=""><img src="../../static/img/images/police.jpg" alt="" /></a>
        <a href=""><img src="../../static/img/images/beian.gif" alt="" /></a>
    </p>
</div>
<!-- 底部版权 end -->
</body>
</html>