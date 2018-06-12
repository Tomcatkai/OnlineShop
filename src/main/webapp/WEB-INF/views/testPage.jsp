<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/4/27
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layPage快速使用</title>
    <link rel="stylesheet" href="../../static/lib/layui/css/layui.css">
</head>
<body>

<div id="test1"></div>
<script src="../../static/lib/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="../../static/lib/layui/layui.js" type="text/javascript"></script>
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
            ,count: 500000000000 //数据总数，从服务端得到
            ,jump:function (obj, first) {

                //首次不执行
                if(!first){

                }
            }
            ,limit:30
            ,layout:['prev', 'page', 'next','skip']
        });
    });
</script>
</body>
</html>
