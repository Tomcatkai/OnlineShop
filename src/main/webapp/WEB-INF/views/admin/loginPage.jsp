<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/11
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="../../../static/admin/lib/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../../static/admin/css/pageDemo/login/login1.css"/>
</head>

<body>
<div class="qiqiu1 qiqiu">
    <img src="../../../static/admin/img/login/login1/q2.png"/>
    <div class="text">love</div>
</div>
<div class="qiqiu2 qiqiu">
    <img src="../../../static/admin/img/login/login1/q3.png"/>
    <div class="text">love</div>
</div>
<div class="qiqiu3 qiqiu">
    <img src="../../../static/admin/img/login/login1/q4.png"/>
    <div class="text">love</div>
</div>
<div class="qiqiu4 qiqiu">
    <img src="../../../static/admin/img/login/login1/q5.png"/>
    <div class="text">love</div>
</div>
<div class="qiqiu5 qiqiu">
    <img src="../../../static/admin/img/login/login1/q6.png"/>
    <div class="text">love</div>
</div>

<!--	<div class="yun1 yun"> </div>
	<div class="yun2 yun"> </div>
	<div class="yun3 yun"> </div>
	<div class="yun4 yun"> </div>	-->

<div class="login">
    <h1>优书网管理员登录</h1>
    <form class="layui-form" action="${pageContext.request.contextPath}/admin/login.html">
        <div class="layui-form-item">
            <input class="layui-input" name="adminName" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="adminPass" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
        </div>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>
</body>
<script src="../../../static/admin/lib/layui/layui.js"></script>
<script>
</script>
</body>
</html>
