$(function () {
    // 购物车的输入数字
    var timer;
    $('.choose-btns .buy-num').keyup(function(){
        var num=$(".choose-btns input").val();
        timer=setTimeout(function(){
            if(num==""){
                $(".choose-btns input").val(2);
            }
        },1000);
        $('.choose-btns .buy-num').change(function(){
            clearInterval(timer);
        });
    });
    // 购物车的减按钮
    $('.choose-btns .btn-reduce').click(function(){
        $('.choose-btns .btn-add').removeClass("disabled");
        var num=$(".choose-btns input").val();
        if( num<=1){
            num=1;
            $(".choose-btns input").val(num);
            $('.choose-btns .btn-reduce').addClass("disabled");
        }else{
            num--;
            $(".choose-btns input").val(num);
        }
    });
    // 购物车的加按钮
    $('.choose-btns .btn-add').click(function(){
        $('.choose-btns .btn-reduce').removeClass("disabled");
        var num=$(".choose-btns input").val();
        if( num>=199){
            alert("最多购买199件");
            num=199;
            $(".choose-btns input").val(num);
            $('.choose-btns .btn-add').addClass("disabled");
        }else{
            num++;
            $(".choose-btns input").val(num);
        }
    });

    $("#InitCartUrl").click(function () {
        var bookNum = $("#buy-num").val();
        $.ajax({
            url:"/cart/add/"+bookId+".json",
            type:"post",
            dataType:"json",
            async:false,//非异步
            data:{bookNum:bookNum},
            success:function(data){
                if(data.code===1){
                    window.location.href=data.result;
                }else {
                   alert(data.msg);
                }
            }
        });
    });
});