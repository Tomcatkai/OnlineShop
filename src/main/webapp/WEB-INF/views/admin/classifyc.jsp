<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/10
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layPage快速使用</title>
    <link rel="stylesheet" href="../../../static/lib/layui/css/layui.css">
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script src="../../../static/lib/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="../../../static/lib/layui/layui.js" type="text/javascript"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 480
            ,method: 'post'
            ,url: '/admin/classify/clist.json' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'classifyId', title: '分类id', width:80, fixed: 'left'}
                ,{field: 'classifyName', title: '分类名', width:120, sort: true,edit:'text'}
                ,{fixed: 'right', title:'操作', width:180, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url:"/admin/classify/delete.json",
                        type:"post",
                        dataType:"json",
                        data:{classifyId:data.classifyId},
                        async:false,//非异步
                        success:function(data){
                            if (data.code===0){
                                layer.alert("操作失败,该分类下还有其他子分类!")
                            }
                        }
                    });
                });
            }
        });


        table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            $.ajax({
                url:"/admin/classify/change.json",
                type:"post",
                dataType:"json",
                data:{classifyId:obj.data.classifyId,classifyName:obj.value},
                async:false,//非异步
                success:function(data){
                    if (data.code===0){
                        layer.alert("操作失败")
                    }
                }
            });
        });

    });
</script>
</body>
</html>
