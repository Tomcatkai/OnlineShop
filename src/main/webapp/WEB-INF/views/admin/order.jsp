<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/9
  Time: 13:41
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
    <a class="layui-btn layui-btn-xs" lay-event="edit">发货</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

    <!-- 这里同样支持 laytpl 语法，如： -->
    {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
    {{#  } }}
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 480
            ,method: 'post'
            ,url: '/admin/order/msg.json' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'orderId', title: '订单id', width:80, fixed: 'left'}
                ,{field: 'orderTime', title: '下单时间', width:120, sort: true}
                ,{field: 'orderTotal', title: '订单总额', width:120, sort: true}
                ,{field: 'addressReceiver', title: '收货人姓名', width: 110}
                ,{field: 'addressReceiverPhone', title: '收货人号码', width: 120}
                ,{field: 'addressDetail', title: '详细收货地址', width: 120, sort: true}
                ,{field: 'addressProvince', title: '收货省份', width: 120}
                ,{field: 'addressCity', title: '收货城市', width: 135}
                ,{field: 'addressArea', title: '收货地区', width: 135}
                ,{field: 'loginName', title: '登录名', width: 135}
                ,{field: 'orderStatus', title: '订单状态', width:90}
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
                        url:"/admin/order/delete.json",
                        type:"post",
                        dataType:"json",
                        data:{orderId:data.orderId},
                        async:false,//非异步
                        success:function(data){
                            if (data.code===0){
                                layer.alert("操作失败,该订单目前并未处于完成状态,无法删除!")
                            }
                        }
                    });
                });
            } else if(layEvent === 'edit'){ //发货
                //do something
                $.ajax({
                    url:"/admin/order/delivery.json",
                    type:"post",
                    dataType:"json",
                    data:{orderId:data.orderId,status:2},
                    async:false,//非异步
                    success:function(data){
                        if (data.code===0){
                            layer.alert("操作失败")
                        }
                    }
                });
                //同步更新缓存对应的值
                obj.update({
                    orderStatus: '已发货'
                    // ,title: 'xxx'
                });
            }
        });

    });
</script>
</body>
</html>
