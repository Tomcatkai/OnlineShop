$(function () {
    $(".box-item").mouseover(function () {
        $(this).css({'box-shadow': '0px 0px 3px rgba(59, 154, 236, 1)'})
    });
    $(".box-item").mouseleave(function () {
        $(this).css({'box-shadow': 'none'})
    });//图片特效
    $(".attention").mouseover(function () {
        $(this).css({"background-position": "-8px -69px"})
    });
    $(".attention").mouseleave(function () {
        $(this).css({"background-position": "-83px -69px"})
    });//关注
    $(".mui-btn-s").mouseover(function () {
        $(this).css({"color": "#e3393c"})
    });
    $(".mui-btn-s").mouseleave(function () {
        $(this).css({"color": "#333"})
    });//确定按钮
    $("ol li").mouseover(function (e) { //鼠标放上去要发生的事情
        var $index = $(this).index();
        $("#banner ul").stop().animate({top: -$index * 358}, 500)
        $(this).addClass("current").siblings().removeClass();
        $key = $index + 1;
        if ($key == 4) {
            $key = 0;
        }
    });
    //轮播图
    //  定时器开始
    var $key = 0;  // 大的全局变量  我们看做是一把钥匙
    var timer = setInterval(autoplay, 4000); //这个定时器的名称是timer
    function autoplay() {
        $("#banner ul").stop().animate({top: -$key * 358}, 500)
        $("ol li").eq($key).addClass("current").siblings().removeClass();
        $key++;
        if ($key > 3) {
            $key = 0;
        }
    }

    $("#banner").hover( //鼠标放到大盒子上  定时器会停止 鼠标离开 定时器继续
        function () {
            clearInterval(timer);
        },
        function () {
            clearInterval(timer);  //多年的经验  要想开启定时器，首先清除定时器
            timer = setInterval(autoplay, 4000);//开启定时器
        });
    $(window).scroll(function (e) {  // 测试滚动条滚动
        var $topvalue = $(document).scrollTop();// 检测滚动条滚动了多少
        /* alert($topvalue);*/
        if ($topvalue > 709) {

            $("#search").css({"position": "fixed", "top": "0", "left": "0", "right": "0"});
        }
        else {
            $("#search").css({position: "relative"});
        }
    });

    $(".mc>.item").mouseover(function () {
        $(this).css({"background-color": "#f7f7f7"});
        $(this).children("a").css({"color": "#0c7edf"});
        $(this).children('.item-down').css({"display": "block"})
        $(".mc>.item").mouseleave(function () {
            $(this).css({"background": "none"});
            $(this).children("a").css({"color": "#fff"});
            $(this).children('.item-down').css({"display": "none"})
        });
    });

    $("#page .page-in a").click(function (e) { //鼠标放上去要发生的事情
        var $index = $(this).index();
        $("#brands-in ul").stop().animate({left: -$index * 906}, 500)
        $(this).addClass("current1").siblings().removeClass();
        $key = $index + 1;
        if ($key == 4) {
            $key = 0;
        }
    });

    $(".close").click(
        function () {
            $("#top_banner").hide();
        }
    );
    $(".buy li.myylm").mouseenter(
        function () {
            $(this).css("box-shadow", "0 0 1px #BBB");
            $(".buy li.myylm a.a1").css("background", "url(mymain_images/index_icons.png) no-repeat -681px -206px").siblings().show();
        }
    );
    $(".buy li.myylm").mouseleave(
        function () {
            $(this).css("box-shadow", "0 0 0 #BBB");
            $(".buy li.myylm a.a1").css("background", "url(mymain_images/index_icons.png) no-repeat -681px -184px").siblings().hide();
        }
    );
    $(".buy li.accounts").mouseenter(
        function () {
            $(this).css("box-shadow", "0 0 1px #BBB").children(".jiesuan").show();
        }
    );
    $(".buy li.accounts").mouseleave(
        function () {
            $(this).css("box-shadow", "0 0 0 #BBB").children(".jiesuan").hide();
        }
    );

    /*导航右边动画*/
    var a = 0;
    var b = 0;

    zidong();

    function zidong() {
        window.clearInterval(b);
        b = setInterval(function () {
            if (a < $(".nav_right li").length - 1) {
                a++;
            } else {
                a = 0;
            }
            $(".nav_right ul li").eq(a).show().siblings().hide();
        }, 2000);
    }


    /**
     * 图书信息展示
     *
     */
    var totalRecord = 0;//初始化总记录数
    var pageNum = 1;//初始化页数为第一页
    var pageSize = 20;//每页显示条数20条
    getBookData();

    function getBookData() {
        $.ajax({
            type: "post",
            async: false,
            url: "/index/bookList.json",
            data: {pageNum: pageNum, pageSize: pageSize},
            success: function (data) {
                totalRecord = data.total;//数据总条数
                fillDataToPage(data.list)
            }
        });
    }

    /**
     * 填充数据
     * @param data
     */
    function fillDataToPage(data) {
        var i = 0;
        for (i; i < data.length; i++) {
            $('#book-list').append('<li class="box-item posi-a" style="margin-right: 13px;margin-top: 10px;">\n' +
                '            <a target="_blank" href="/book/detail/' + data[i].bookId + '.html" >\n' +
                '                <img src="' + data[i].bookPicBig + '"/>\n' +
                '                <div class="down">\n' +
                '                    <h2 class="box-title">\n' +
                '                        <span style="display: block;\n' +
                '  width: 120px;\n' +
                '  overflow: hidden;\n' +
                '  white-space: nowrap;\n' +
                '  text-overflow: ellipsis;">' + data[i].bookName + '</span>\n' +
                '                    </h2>\n' +
                '                    <h5 class="box-title1">' + data[i].bookSubhead + '</h5>\n' +
                '                </div>\n' +
                '            </a>\n' +
                '        </li>')
        }
    }

    /**
     * 分页插件
     */
    // function toPage() {

    layui.use('laypage', function () {
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'mui-page' //注意，这里的 test1 是 ID，不用加 # 号
            , count: totalRecord //数据总数，从服务端得到
            , curr: pageNum
            , limit: pageSize
            , jump: function (obj, first) {
                //obj包含了当前分页的所有参数，比如：
                pageNum = obj.curr;//得到当前页，以便向服务端请求对应页的数据。
                pageSize = obj.limit;//得到每页显示的条数

                //首次不执行
                if (!first) {
                    //do something
                    $('#book-list').empty();
                    getBookData();
                }
            }
        });
    });
    // }
});