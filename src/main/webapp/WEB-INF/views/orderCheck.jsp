<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/6
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>填写核对订单信息</title>
    <link rel="stylesheet" href="../../static/css/style/base.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/global.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/header.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/fillin.css" type="text/css">
    <link rel="stylesheet" href="../../static/css/style/footer.css" type="text/css">
    <link rel="stylesheet" href="../../static/lib/layui_old/css/layui.css"/>
    <script type="text/javascript" src="../../static/js/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../static/lib/layui_old/layui.js"></script>
    <script type="text/javascript" src="../../static/lib/assets/data.js"></script>
    <script type="text/javascript" src="../../static/lib/assets/province.js"></script>
    <script type="text/javascript" src="../../static/js/js/cart2.js"></script>
</head>
<body>
<script type="text/javascript">
    var defaults = {
        s1: 'provid',
        s2: 'cityid',
        s3: 'areaid',
        v1: null,
        v2: null,
        v3: null
    };
</script>
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
        <div class="flow fr flow2">
            <ul>
                <li>1.我的购物车</li>
                <li class="cur">2.填写核对订单信息</li>
                <li>3.成功提交订单</li>
            </ul>
        </div>
    </div>
</div>
<!-- 页面头部 end -->

<div style="clear:both;"></div>

<!-- 主体部分 start -->
<div class="fillin w990 bc mt15">
    <div class="fillin_hd">
        <h2>填写并核对订单信息</h2>
    </div>

    <div class="fillin_bd">
        <!-- 收货人信息  start-->
        <div class="address">
            <h3 id="people_msg"></h3>
            <div class="address_info" id="people_detail">
            </div>

            <div class="address_select none">
                <ul id="location_ul">
                    <li><input type="radio" name="address" class="new_address" id="new_address"/>使用新地址</li>
                </ul>
                <%--<form action="" class="none" name="address_form">--%>
                <ul class="none" name="address_form" id="address_form">
                    <li>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span>*</span>收货人:</label>
                            <div class="layui-input-block">
                                <input type="text" id="new_receiver" name="receiver" required lay-verify="required" placeholder="请输入收货人"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </li>
                    <li>
                        <!--地址级联开始-->
                        <%--<div style="width:800px;margin:50px auto;">--%>
                        <form class="layui-form">
                            <div class="layui-form-item">
                                <label class="layui-form-label">选择地区:</label>
                                <div class="layui-input-inline">
                                    <select name="provid" id="provid" lay-filter="provid">
                                        <option value="">请选择省</option>
                                    </select>
                                </div>
                                <div class="layui-input-inline">
                                    <select name="cityid" id="cityid" lay-filter="cityid">
                                        <option value="">请选择市</option>
                                    </select>
                                </div>
                                <div class="layui-input-inline">
                                    <select name="areaid" id="areaid" lay-filter="areaid">
                                        <option value="">请选择县/区</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <%--</div>--%>
                        <!--地址级联结束-->
                    </li>
                    <li>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span>*</span>地址：</label>
                            <div class="layui-input-block">
                                <input type="text" name="title" required lay-verify="required" placeholder="请输入详细地址"
                                       autocomplete="off" class="layui-input" id="new_address_detail">
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="layui-form-item">
                            <label class="layui-form-label"><span>*</span>号码：</label>
                            <div class="layui-input-block">
                                <input type="text" name="title" required lay-verify="required" placeholder="请输入手机号码"
                                       autocomplete="off" class="layui-input" id="new_address_phone">
                            </div>
                        </div>
                    </li>
                    <a class="confirm_btn" id="confirm_btn"><span>保存收货人信息</span></a>
                </ul>
                <%--</form>--%>

            </div>
        </div>

        <!-- 商品清单 start -->
        <div class="goods">
            <h3>商品清单</h3>
            <table>
                <thead>
                <tr>
                    <th class="col1">商品</th>
                    <th class="col2"></th>
                    <th class="col3">价格</th>
                    <th class="col4">数量</th>
                    <th class="col5">小计</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${cartVo.cartItemDtos}">
                    <tr>
                        <td class="col1"><a href=""><img src="${item.bookPicBig}" alt=""/></a> <strong><a
                                href="">${item.bookName}</a></strong></td>
                        <td class="col2">
                                <%--<p>颜色：073深红</p> <p>尺码：170/92A/S</p> --%>
                        </td>
                        <td class="col3">￥${item.bookPriceCurrent}</td>
                        <td class="col4">${item.cartBookNum}</td>
                        <td class="col5"><span>￥${item.colSubTotal}</span></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="5">
                        <ul>
                            <%--<li>--%>
                            <%--<span>4 件商品，总商品金额：</span>--%>
                            <%--<em>￥5316.00</em>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<span>返现：</span>--%>
                            <%--<em>-￥240.00</em>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                            <%--<span>运费：</span>--%>
                            <%--<em>￥10.00</em>--%>
                            <%--</li>--%>
                            <li>
                                <span>总计金额：</span>
                                <em>￥${cartVo.allSubTotal}</em>
                            </li>
                        </ul>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
        <!-- 商品清单 end -->

    </div>

    <div class="fillin_ft">
        <a id="orderCreate"><span>提交订单</span></a>
        <p>应付总额：<strong>￥${cartVo.allSubTotal}元</strong></p>

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
