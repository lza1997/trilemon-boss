<!doctype html>
<html xmlns:ng="http://angularjs.org" lang="zh">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title ng-bind="title"></title>

    <#assign asset = "/assets">

    <link href="${asset}/base/css/font-awesome.css" rel="stylesheet">
    <link href="${asset}/css/application.css" rel="stylesheet">
    <style>
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
            display: none !important;
        }
    </style>

    <!--[if lt IE 9]>
    <script src="${asset}/base/js/html5shiv.js"></script>
    <![endif]-->

    <!--[if lt IE 8]>
    <link href="${asset}/base/css/font-awesome-ie7.css" rel="stylesheet"/>
    <script src="${asset}/base/js/jquery.js"></script>
    <script src="${asset}/base/js/json2.js"></script>
    <![endif]-->

    <script src="${asset}/base/sea-modules/seajs/seajs/2.1.1/sea.js"></script>

    <link rel="shortcut icon" href="${asset}/ico/favicon.ico">
</head>

<body ng-cloak>

<header>
    <div class="trilemon-banner">
        <div class="container">
            <a href="/" style="color:white" class="logo" title="Trilemon"></a>
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

<div class="container main" ng-view ng-cloak>
</div>

<footer>
    <div class="container">
        <p class="list-inline text-center">
            <span> &copy; 2013 GYSB, Inc. </span>
            <a href="">联系我们</a>
            <a href="">使用帮助</a
        </p>
    </div>
</footer>
<!--[if lt IE 8]>
<script src="${asset}/js/ie7-fix.js"></script>
<![endif]-->
<script>
    // footer
    (function() {
        var style = document.createElement('style');
        var head = document.getElementsByTagName('head')[0] || document.documentElement;
        var minHeight = window.innerHeight || Math.max(document.documentElement.clientHeight, document.body.clientHeight);
        var cssText = '.main {min-height: ' + (minHeight - 250) + 'px}';
        head.appendChild(style);
        if (style.styleSheet) {
            style.styleSheet.cssText += cssText;
        }
        else {
            style.appendChild(document.createTextNode(cssText))
        }
    })();
    seajs.config({
        alias: {
            'angularjs': 'angular/angularjs/1.2.7/angular',
            'angular-animate': 'angular/angularjs/1.2.7/angular-animate',
            'angular-resource': 'angular/angularjs/1.2.7/angular-resource',
            'angular-route': 'angular/angularjs/1.2.7/angular-route',
            'angular-sanitize': 'angular/angularjs/1.2.7/angular-sanitize',

            '_': 'gallery/underscore/1.4.4/underscore',
            'moment': 'gallery/moment/2.3.1/moment',
            'bootstrap': 'angular/bootstrap/0.0.1/index',
            'angular-highcharts': 'angular/angular-highcharts/3.0.7/angular-highcharts',
            'seajs-lazy-angular': 'angular/seajs-lazy-angular/0.0.1/seajs-lazy-angular'
        },
        preload: ['seajs/seajs-text/1.0.3/seajs-text'],
        paths: {
            'app': '${asset}/js'
        }
    });
    seajs.on('exec', function(m) {
        if (m.exports) {
            m.exports.__moduleUri = m.uri;
        }
    });
    seajs.use('${asset}/js/app');
</script>
</body>
</html>