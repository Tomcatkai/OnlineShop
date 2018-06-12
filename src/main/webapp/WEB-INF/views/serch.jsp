<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/11
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高级搜索</title>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
</head>
<body>
<div style="text-align: center">
    <form class="layui-form" action="${pageContext.request.contextPath}/book/querycombine.html" style="position: relative; left: 900px;top: 300px;">
        <div class="layui-form-item">
            <label class="layui-form-label">图书名:</label>
            <div class="layui-input-inline">
                <input type="text" name="bookName" required  lay-verify="required" placeholder="请输入图书名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者:</label>
            <div class="layui-input-inline">
                <input type="text" name="author" required  lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">ISBN:</label>
            <div class="layui-input-inline">
                <input type="text" name="ISBN" required  lay-verify="required" placeholder="请输入图书的ISNB号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出版社:</label>
            <div class="layui-input-inline">
                <input type="text" name="publisher" required  lay-verify="required" placeholder="请输入出版社" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="position: relative; left: 100px;">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="../../static/lib/layui/layui.js" type="text/javascript"></script>
<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        // //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    });
</script>
</body>
</html>