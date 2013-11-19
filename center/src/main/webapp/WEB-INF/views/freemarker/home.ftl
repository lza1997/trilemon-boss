<!doctype html>
<html xmlns:ng="http://angularjs.org" lang="zh" id="ng-app" ng-app="app">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title ng-bind="title"></title>

    <#assign asset = "/assets">

    <link href="${asset}/base/css/bootstrap.css" rel="stylesheet">
    <link href="${asset}/base/css/font-awesome.css" rel="stylesheet">
    <link href="${asset}/css/application.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${asset}/base/js/html5shiv.js"></script>
    <script src="${asset}/base/js/respond.min.js"></script>
    <script>
        document.createElement('pagination');
    </script>
    <![endif]-->

    <script src="${asset}/base/js/sea-modules/seajs/seajs/2.1.1/sea-debug.js"></script>
    <script src="${asset}/base/js/underscore.js"></script>
    <script src="${asset}/base/js/jquery.js"></script>
    <script src="${asset}/base/js/highcharts.src.js"></script>
    <script src="${asset}/base/js/angular.js"></script>
    <script src="${asset}/base/js/angular-resource.js"></script>
    <script src="${asset}/base/js/angular-route.js"></script>
    <script src="${asset}/base/js/angular-sanitize.js"></script>
    <script src="${asset}/base/js/restangular.js"></script>
    <script src="${asset}/base/js/bootstrap/index.js"></script>
    <script src="${asset}/base/js/bootstrap/angular-dropdown.js"></script>
    <script src="${asset}/base/js/bootstrap/angular-pagination.js"></script>
    <script src="${asset}/base/js/bootstrap/angular-modal.js"></script>
    <script src="${asset}/base/js/bootstrap/angular-tabs.js"></script>
    <script src="${asset}/base/js/seajs-lazy-module.js"></script>
    <script src="${asset}/base/js/angular/ajax-spinner.js"></script>
    <script src="${asset}/base/js/angular/highchart.js"></script>

    <script src="${asset}/js/app.js"></script>
    <script src="${asset}/js/common/index.js"></script>
    <script src="${asset}/js/common/flash.js"></script>
    <script src="${asset}/js/common/rest.js"></script>
    <script src="${asset}/js/common/seller-cat-factory.js"></script>
    <script src="${asset}/js/common/controller/nav.js"></script>
    <script src="${asset}/js/common/constant.js"></script>
    <script src="${asset}/js/common/http-method-override.js"></script>

    <!--[if lt IE 8]>
    <link href="${asset}/base/css/font-awesome-ie7.css" rel="stylesheet" />
    <script src="${asset}/base/js/json2.js"></script>
    <script src="${asset}/base/js/angular/animate-ie7fix.js"></script>
    <script>
        app.config(AnimateIE7Fix);
    </script>
    <![endif]-->

    <script>
        seajs.config({
            preload: ['seajs/seajs-text/1.0.3/seajs-text'],
            paths: {
                'app':'${asset}/js'
            }
        });
    </script>

    <link rel="shortcut icon" href="${asset}/base/ico/favicon.ico">
</head>

<body>

<header>
    <div class="trilemon-banner">
        <div class="container">
            <a href="/" style="color:white" class="logo">Trilemon</a>
        </div>
    </div>
    <div class="navbar navbar-default trilemon-navbar">
        <div class="container">
            <ul class="nav navbar-nav" ng-controller="nav">
                <li class="dropdown">
                    <a class="nav-menu-trigger dropdown-toggle" href="">
                        <i class="icon-reorder"></i> {{currNav.name}}
                    </a>
                    <ul class="dropdown-menu">
                        <li ng-repeat="nav in navs"><a ng-href="{{'#' + nav.url}}">{{nav.name}}</a></li>
                    </ul>
                </li>
                <li ng-repeat="childNav in currNav.children" ng-class="{active: navClass == childNav.navClass}">
                    <a ng-href="{{'#' + childNav.url}}">{{childNav.name}}</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<div ajax-spinner></div>

<div class="container" ng-view ng-cloak>
</div>

<footer>
    <div class="container">
        <ul class="list-inline">
            <li>© 2013 GLSB, Inc.</li>
            <li><a href="">联系我们</a></li>
            <li><a href="">使用帮助</a></li>
        </ul>
    </div>
</footer>
</body>
</html>