<%--
  Created by IntelliJ IDEA.
  User: kai
  Date: 2018/5/9
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>优书网后台</title>
    <link rel="stylesheet" href="../../../static/admin/lib/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../../static/admin/css/hp-layui.css" />
    <link rel="shortcut icon" href="../../../static/admin/favicon.ico" />
</head>

<body class="layui-layout-body hp-white-theme">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            欢迎来到优书网
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon"></i>主题<span class="layui-nav-more"></span></a>
                <dl class="layui-nav-child layui-anim layui-anim-upbit">
                    <dd>
                        <a skin="hp-black-theme" class="hp-theme-skin-switch" href="javascript:;">低调黑</a>
                    </dd>
                    <dd>
                        <a skin="hp-blue-theme" class="hp-theme-skin-switch" href="javascript:;">炫酷蓝</a>
                    </dd>
                    <dd>
                        <a skin="hp-green-theme" class="hp-theme-skin-switch" href="javascript:;">原谅绿</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="">退出</a>
            </li>
        </ul>
    </div>

    <div class="layui-side hp-left-menu">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav hp-nav-none">
                <li class="layui-nav-item">
                    <a href="javascript:;" class="hp-user-name">
                        <img src="../../../static/admin/img/1.jpg" class="layui-circle-img"><span class="hp-kd">张凯</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="">基本资料</a>
                        </dd>
                        <dd>
                            <a href="">安全设置</a>
                        </dd>
                    </dl>
                </li>
            </ul>

            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon hp-icon-size">&#xe609;</i>分类管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a class="hp-tab-add" hp-href="/admin/classifyp.html" href="javascript:;">
                                <i class="layui-icon hp-icon-size">&#xe658;</i>父分类 删除/修改
                            </a>
                        </dd>
                        <dd>
                            <a class="hp-tab-add" hp-href="/admin/classifyc.html" href="javascript:;">
                                <i class="layui-icon hp-icon-size">&#xe662;</i>子分类 删除/修改
                            </a>
                        </dd>
                        <dd>
                            <a class="hp-tab-add" hp-href="/admin/new/classify/page.html" href="javascript:;">
                                <i class="layui-icon hp-icon-size">&#xe662;</i>新建分类
                            </a>
                        </dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon hp-icon-size">&#xe64c;</i>订单管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a class="hp-tab-add" hp-href="/admin/order.html">
                                <i class="layui-icon hp-icon-size">&#xe658;</i> 订单处理
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab hp-tab " style="" lay-filter="hp-tab-filter" lay-allowclose="true">
            <ul class="layui-tab-title" style="">
                <li class="layui-this" lay-id="0">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="layui-carousel" id="test1">
                        <div carousel-item>
                            <div>
                                <div class="layui-bg-green demo-carousel">
                                    <p style="font-size: 30px;">优书网</p>
                                    <p style="font-size: 28px;">张凯</p>
                                </div>
                            </div>
                            <div>
                                <div class="layui-bg-red demo-carousel">
                                    <p style="font-size: 30px;">优书网</p>
                                    <p style="font-size: 28px;">张凯</p>
                                </div>
                            </div>
                            <div>
                                <div class="layui-bg-blue demo-carousel">
                                    <p style="font-size: 30px;">优书网</p>
                                    <p style="font-size: 28px;">张凯</p>
                                </div>
                            </div>
                            <div>
                                <div class="layui-bg-orange demo-carousel">
                                    <p style="font-size: 30px;">优书网</p>
                                    <p style="font-size: 28px;">张凯</p>
                                </div>
                            </div>
                            <div>
                                <div class="layui-bg-cyan demo-carousel">
                                    <p style="font-size: 30px;">优书网</p>
                                    <p style="font-size: 28px;">张凯</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 优书网-version-1.0
    </div>
</div>
<script src="../../../static/admin/lib/layui/layui.js"></script>
<script>
    // 配置
    layui.config({
        base: '../../../static/admin/hpModules/' // 扩展模块目录
    }).extend({ // 模块别名
        hpTab: 'hpComponent/hpTab',
        hpRightMenu: 'hpComponent/hpRightMenu',
        hpFormAll: 'hpComponent/hpFormAll',
        hpLayedit: 'hpComponent/hpLayedit',
        hpTheme: 'hpComponent/hpTheme',
        test: '../../../static/admin/other/test' // {/}的意思即代表采用自有路径，即不跟随 base 路径
    });

    //JavaScript代码区域
    layui.use(['element', 'carousel', 'hpTheme', 'hpTab', 'hpLayedit', 'hpRightMenu', 'test'], function() {

        var element = layui.element;
        var carousel = layui.carousel; //轮播
        var hpTab = layui.hpTab;
        var hpRightMenu = layui.hpRightMenu;
        var hpTheme = layui.hpTheme;
        $ = layui.jquery;
        /*var test=layui.test;
        console.log(test.version) */
        // 初始化主题
        hpTheme.init();
        //初始化轮播
        carousel.render({
            elem: '#test1',
            width: '100%', //设置容器宽度
            interval: 1500,
            height: '500px',
            arrow: 'none', //不显示箭头
            anim: 'fade', //切换动画方式
        });

        // 初始化 动态tab
        hpTab.init();
        // 右键tab菜单
        hpRightMenu.init();

    });
</script>
</body>

</html>