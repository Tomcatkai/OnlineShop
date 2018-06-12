$(function () {
    /**
     * 输入框得到焦点隐藏提示信息
     */
    $(".layui-input").focus(function () {
        var tipsId = this.id+"Tip";
        $("#"+tipsId).css("display","none");
        $("#"+tipsId+"Value").html("");
    });
    /**
     * 输入框失去焦点进行校验
     */
    $(".layui-input").blur(function () {
        var functionName = "validate"+this.id.substring(0,1).toUpperCase()+this.id.substring(1)+"();";
        if(!eval(functionName)){
            var tipsId = this.id+"Tip";
            $("#"+tipsId).css("display","block");
        }
    });


    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(login)', function(){
            var  bool = true;
            if(!validateUserName()){
                bool = false;
            }
            if(!validatePassword()){
                bool = false;
            }
            if(!validateVerificationCode()){
                bool = false;
            }
            return bool;
        });
    });

    /**
     * 校验用户名方法
     */
    function validateUserName() {
        var id = "userName";
        var value = $("#"+id).val();
        /**
         * 1.非空校验
         */
        if(!value){
            $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>用户名不能为空!");
            return false;
        }
        /**
         * 2.长度校验
         */
        if(value.length<3 || value.length>20){
            /**
             *获取对应的label添加提示信息
             */
            $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>用户名长度应在3-20之间!");
            return false;
        }
        return true;
    }

    /**
     * 校验密码方法
     */
    function validatePassword() {
        var id = "password";
        var value = $("#"+id).val();
        /**
         * 非空校验
         */
        if(!value){
            $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>密码不能为空!");
            return false;
        }
        /**
         * 长度校验
         */
        if(value.length<3 || value.length>20){
            $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>密码长度须在3-20之间!");
            return false;
        }
        return true;
    }

    /**
     * 校验验证码
     */
    function validateVerificationCode() {
        var id = "verificationCode";
        var value = $("#"+id).val();
        /**
         * 非空校验
         */
        if(!value){
            $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>验证码不能为空!");
            return false;
        }
        /**
         * 验证码是否正确校验
         */
        var result = true;
        $.ajax({
            url:"/user/verify/check.json",
            type:"post",
            dataType:"json",
            data:{inputCode:value},
            async:false,//非异步
            success:function(data){
                if(!data.result){
                    $("#"+id+"TipValue").html("<i class=\"layui-icon icon\">&#x1007;</i>验证码错误!");
                    result = false;
                }
            }
        });
        return result;
    }

    $("#change").click(function () {
        $("#verifyCodePic").attr("src","/user/verify.json?a="+new Date().getTime());
    })

});