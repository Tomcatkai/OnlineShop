<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/6
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>商品列表页</title>
    <link rel="stylesheet" href="../../static/css/style/base.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/global.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/header.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/list.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/common.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/bottomnav.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/footer.css" type="text/css">
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
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

<!-- 列表主体 start -->
<div class="list w1210 bc mt10">
    <!-- 面包屑导航 start -->
    <div class="breadcrumb">
        <h2>当前位置：<a href="">首页</a> > <a href="">搜索结果页</a></h2>
    </div>
    <!-- 面包屑导航 end -->

    <!-- 列表内容 start -->
    <div class="list_bd fl ml10 mt10">

        <div style="clear:both;"></div>

        <!-- 商品列表 start-->
        <div class="goodslist mt10">
            <ul>
                <c:forEach var="book" items="${pageInfo.list}">
                    <li>
                        <dl>
                            <dt><a href=""><img src="${book.bookPicBig}" alt=""/></a></dt>
                            <dd><a href="">${book.bookName}</a></dd>
                            <dd><strong>￥${book.bookPriceCurrent}</strong></dd>
                            <%--<dd><a href=""><em>${book.bookSubhead}</em></a></dd>--%>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!-- 商品列表 end-->

        <!-- 分页信息 start -->
        <div id="mui-page" class="mui-page"></div>
        <!-- 分页信息 end -->

    </div>
    <!-- 列表内容 end -->
</div>
<!-- 列表主体 end-->

<div style="clear:both;"></div>
<!-- 底部导航 start -->
<div class="bottomnav w1210 bc mt20">
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
            <li><a href=""优书礼品卡</a></li>
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
        © 2005-2013 优书网 版权所有，并保留所有权利。 ICP备案证书号:京ICP证070359号
    </p>
    <p class="auth">
        <a href=""><img src="../../static/img/images/xin.png" alt=""/></a>
        <a href=""><img src="../../static/img/images/kexin.jpg" alt=""/></a>
        <a href=""><img src="../../static/img/images/police.jpg" alt=""/></a>
        <a href=""><img src="../../static/img/images/beian.gif" alt=""/></a>
    </p>
</div>
<!-- 底部版权 end -->
<script type="text/javascript" src="../../static/js/js/jquery-1.8.3.min.js"></script>
<script src="../../static/lib/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript" src="../../static/js/js/header.js"></script>
<script type="text/javascript" src="../../static/js/js/list.js"></script>
<script type="text/javascript">
    var pageNum =${pageInfo.pageNum};
    var pageSize=${pageInfo.pageSize};
    var total =${pageInfo.total};
    var requireJson =${require};
    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'mui-page' //注意，这里的 test1 是 ID，不用加 # 号
            , count: total //数据总数，从服务端得到
            , curr: pageNum
            ,limit:10
            , jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                pageNum = obj.curr;//得到当前页，以便向服务端请求对应页的数据。
                pageSize = obj.limit;//得到每页显示的条数
                var url;
                if(requireJson.kind==="name"){
                    url ='/book/queryname.html?bookName='+requireJson.bookName+'&'+'pageNum='+pageNum+'&pageSize='+pageSize;
                }else if(requireJson.kind==="author"){
                    url = '/book/queryauthor.html?author='+requireJson.author+'&pageNum='+pageNum+'&pageSize='+pageSize;
                }else if (requireJson.kind==="publisher"){
                    url = '/book/querypublisher.html?publisher='+requireJson.publisher+'&pageNum='+pageNum+'&pageSize='+pageSize;
                }else if(requireJson.kind==="classify"){
                    url = '/book/queryclassify.html?classify='+requireJson.classify+'&pageNum='+pageNum+'&pageSize='+pageSize;
                }else if(requireJson.kind==="combine"){
                    url = '/book/querycombine.html?bookName='+requireJson.bookName+'&author='+requireJson.author+'&ISBN='+requireJson.ISBN+'&publisher='+requireJson.publisher+'&pageNum='+pageNum+'&pageSize='+pageSize;
                }
                //首次不执行
                if (!first) {
                    window.location.href=url;
                }
            }
        });
    });
</script>
</body>
</html>