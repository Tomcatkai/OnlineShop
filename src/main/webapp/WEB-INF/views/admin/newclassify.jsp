<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/10
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新建分类</title>
    <link rel="stylesheet" href="../../../static/lib/layui/css/layui.css">
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script src="../../../static/lib/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="../../../static/lib/layui/layui.js" type="text/javascript"></script>
    <form class="layui-form" action="" style="">
        <div class="layui-form-item">
            <label class="layui-form-label">分类名</label>
            <div class="layui-input-inline">
                <input type="text" name="classifyName" required  lay-verify="required" placeholder="请输入要创建的分类名" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">例如:  语文</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设为父分类</label>
            <div class="layui-input-block">
                <input type="checkbox"  lay-filter="setp" name="isParent" lay-skin="switch">
            </div>
        </div>
        <div class="layui-form-item" id="classify-p">
            <label class="layui-form-label">所属父分类</label>
            <div class="layui-input-inline">
                <select name="classifyPid" lay-verify="required" id="opt-zero">
                    <option id="" value=""></option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>



<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        $.ajax({
            url:"/admin/classify/plist.json",
            type:"post",
            dataType:"json",
            data:{page:1,limit:1000},
            async:true,//非异步
            success:function(data){
                for(var i = 0;i<data.data.length;i++){
                    var classifyName = data.data[i].classifyName;
                    var classifyId = data.data[i].classifyId;
                    var option = '<option value="'+classifyId+'">'+classifyName+'</option>';
                    $("#opt-zero").append(option);
                }
                form.render();
            },
            error:function () {
                layer.msg("网络异常!!!");
            }
        });

        //监听提交
        form.on('submit(formDemo)', function(data){
            $.ajax({
                url:"/admin/classify/new.json",
                type:"post",
                dataType:"json",
                data:{classifyName:data.field.classifyName,classifyPid:data.field.classifyPid},
                async:true,//非异步
                success:function(data){
                    if(data.code===1){
                        layer.msg("创建成功!!!");
                    }else {
                        layer.msg("创建失败!!!");
                    }
                },
                error:function () {
                    layer.msg("网络异常!!!");
                }
            });
            return false;
        });

        form.on('switch(setp)', function(data){
          if(data.elem.checked){
              $("#classify-p").empty();
          }else {
              //查询所有父分类
              $.ajax({
                  url:"/admin/classify/plist.json",
                  type:"post",
                  dataType:"json",
                  data:{page:1,limit:1000},
                  async:true,//非异步
                  success:function(data){
                      var htm = '<label class="layui-form-label">所属父分类</label>\n' +
                          '            <div class="layui-input-inline">\n' +
                          '                <select name="classifyPid" lay-verify="required" id="opt-zero">\n' +
                          '                    <option value=""></option>\n' +
                          '                </select>\n' +
                          '            </div>';
                      $("#classify-p").append(htm);
                      for(var i = 0;i<data.data.length;i++){
                         var classifyName = data.data[i].classifyName;
                         var classifyId = data.data[i].classifyId;
                          var option = '<option value="'+classifyId+'">'+classifyName+'</option>';
                          $("#opt-zero").append(option);
                      }
                      form.render();
                  }
              });
          }

        });

        form.on('select(filter)', function(data){
            console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            console.log(data.othis); //得到美化后的DOM对象
        });
    });
</script>
</body>
</html>