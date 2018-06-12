<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/3/28
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="Shortcut Icon" href="../../../static/img/faction.png" />
    <title>用户登录</title>
</head>
<link rel="stylesheet" href="../../../static/css/initialize.css">
<link rel="stylesheet" href="../../../static/lib/layui/css/layui.css">
<link rel="stylesheet" href="../../../static/css/login.css">
<body>
<div class="wrapper">
    <div class="logo-container">
        <img class="logo" src="../../../static/img/logo-small1.png">
    </div>
    <div class="login-box-wrapper">
        <h1 class="h1">登录</h1>
        <form class="layui-form" action="/user/login.html" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名:</label>
                <div class="layui-input-block">
                    <input type="text" id="userName" name="loginName" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
                <div class="tips" id="userNameTip">
                    <label id="userNameTipValue"></label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码框:</label>
                <div class="layui-input-block">
                    <input type="password" id="password" name="loginPass" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
                <div class="tips" id="passwordTip">
                    <label id="passwordTipValue"></label>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">验证码:</label>
                <div class="layui-input-block">
                    <input type="text" id="verificationCode" name="check" required lay-verify="username" placeholder="请输入图形验证码" autocomplete="off" class="layui-input">
                </div>
                <div class="verifyCode">
                    <img id="verifyCodePic" src="/user/verify.json">
                    <label id="change">换一张</label>
                </div>
                <div class="tips" id="verificationCodeTip">
                    <label id="verificationCodeTipValue"></label>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-warm" lay-submit lay-filter="login">登录</button>
                    <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<hr/>
<div class="layui-footer">
    版权所有 © 1995-2018，优书网
</div>
<script src="../../../static/lib/jquery-3.3.1.min.js"></script>
<script src="../../../static/lib/layui/layui.js"></script>
<script src="../../../static/js/login.js"></script>
<c:if test="${not empty msg}">
<script type="text/javascript">

    layui.use('layer', function(){
        var layer = layui.layer;
        layer.open({
            title: '在线调试'
            ,content: '${msg}'
        });
    });
</script>
</c:if>
</body>
</html>