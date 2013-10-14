<!DOCTYPE html>
<html lang="zh" ng-app="app">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title ng-bind="title"></title>

    <#assign asset = "/assets">

    <link href="${asset}/base/css/bootstrap.css" rel="stylesheet">
    <link href="${asset}/shelf/css/shelf.css" rel="stylesheet">
    <link href="${asset}/shelf/css/application.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${asset}/base/lib/html5shiv.js"></script>
    <![endif]-->

    <script src="${asset}/base/js/sea-modules/seajs/seajs/2.1.1/sea-debug.js"></script>
    <script src="${asset}/base/js/seajs-route.js"></script>
    <script src="${asset}/base/js/underscore.js"></script>
    <script src="${asset}/base/js/jquery.js"></script>
    <script src="${asset}/base/js/angular.js"></script>
    <script src="${asset}/base/js/angular-animate.js"></script>
    <script src="${asset}/base/js/angular-resource.js"></script>
    <script src="${asset}/base/js/angular-route.js"></script>
    <script src="${asset}/base/js/restangular.js"></script>

    <script src="${asset}/shelf/js/app.js"></script>

    <script>
        seajs.config({
            preload: ['seajs/seajs-text/1.0.3/seajs-text'],
            paths: {
                'shelf_js':'${asset}/shelf/js'
            }
        });
    </script>

    <link rel="shortcut icon" href="${asset}/assets/ico/favicon.png">
</head>

<body>

<#--<header class="navbar navbar-inverse navbar-fixed-top trilemon-navbar" role="banner">-->
    <#--<div class="docs-nav">-->
        <#--<div class="container">-->
            <#--<div class="navbar-header">-->
                <#--<a href="#" class="navbar-brand">Trilemon</a>-->
            <#--</div>-->
            <#--<nav class="collapse navbar-collapse docs-navbar-collapse" role="navigation">-->
                <#--<ul class="nav navbar-nav pull-right">-->
                    <#--<li>-->
                        <#--<a class="#">麻烦请给我好评</a>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</nav>-->
        <#--</div>-->
    <#--</div>-->

    <#--<div class="docs-minor-nav">-->
        <#--<div class="container">-->
            <#--<ul id="trilemon-menu-nav" class="nav nav-tabs col-lg-3">-->
                <#--<li class="dropdown">-->
                    <#--<a href="#" id="trilemon-menu-home" class="dropdown-toggle"-->
                       <#--data-toggle="dropdown"><i class="icon-list"></i> 上下架-->
                    <#--</a>-->
                    <#--<ul id="trilemon-menu-list" class="dropdown-menu" role="menu" aria-labelledby="trilemon-menu-home">-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">发布商品</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">店铺体检</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">上下架</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">橱窗推荐</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">仓库上架</a>-->
                                <#--<a class="tip pull-right">-->
                                    <#--<small>3个宝贝待上架</small>-->
                                <#--</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">发货</a>-->
                                <#--<a class="tip pull-right">-->
                                    <#--<small>50个订单待发货</small>-->
                                <#--</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">会员管理</a>-->
                            <#--</div>-->
                        <#--</li>-->
                        <#--<li>-->
                            <#--<div>-->
                                <#--<a class="menu" href="#dropdown1" tabindex="-1" data-toggle="tab">评价</a>-->
                                <#--<a class="text-muted tip pull-right">-->
                                    <#--<small>待评价42条</small>-->
                                <#--</a>-->
                            <#--</div>-->
                        <#--</li>-->
                    <#--</ul>-->
                <#--</li>-->
            <#--</ul>-->
            <#--<ul id="trilemon-sub-menu" class="nav navbar-nav">-->
                <#--<li>-->
                    <#--<a href="#">创建手动计划</a>-->
                <#--</li>-->
                <#--<li class="active">-->
                    <#--<a href="#">创建自动计划</a>-->
                <#--</li>-->
                <#--<li >-->
                    <#--<a href="#">计划列表-->
                        <#--<small class="text-muted">我的特价商品计划</small>-->
                    <#--</a>-->
                <#--</li>-->
            <#--</ul>-->
        <#--</div>-->
    <#--</div>-->
<#--</header>-->

<div class="container" ng-view>

</div>

<footer class="doc-footer" role="contentinfo">
    <div class="container">
        <ul class="footer-links pull-right">
            <li><a>店长指南</a></li>&lrm;
            <li><a>店长反馈</a></li>&lrm;
            <li>@超级店长 2013</li>&lrm;
        </ul>
    </div>
</footer>
</body>
</html>