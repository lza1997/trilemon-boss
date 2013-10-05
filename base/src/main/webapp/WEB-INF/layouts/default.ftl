<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <link href="${base}/static/bootstrap/3.0.0/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/static/boostrap-datepicker/css/datepicker.css" rel="stylesheet">
    <link href="${base}/static/assets/css/application.css" rel="stylesheet">
    <link href="${base}/static/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/static/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/static/morris/morris.css" rel="stylesheet" type="text/css"/>
    <script src="${base}/static/jquery/jquery-1.10.2.min.js"></script>

    <!--[if lt IE 9]>
    <script src="${base}/static/assets/js/html5shiv.js"></script>
    <script src="${base}/static/assets/js/respond.min.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="${base}/assets/ico/favicon.png">
</head>

<body>
<#include "/WEB-INF/layouts/header.ftl">

<div class="container opt-docs-container">
    <div class="row">
        <div class="col-md-3">
        <#include "/WEB-INF/layouts/isvLeft.ftl">
        </div>
        <div class="col-md-9" role="main">
        ${body}
        </div>
    </div>
</div>
<#include "/WEB-INF/layouts/footer.ftl">
<script src="${base}/static/moment/moment.js" type="text/javascript"></script>
<script src="${base}/static/moment/zh-cn.js" type="text/javascript"></script>
<script src="${base}/static/bootstrap/3.0.0/js/bootstrap.js"></script>
<script src="${base}/static/boostrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="${base}/static/boostrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js" charset="utf-8"></script>
<script src="${base}/static/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${base}/static/bootstrap-select/bootstrap-select.min.js"></script>
<script src="${base}/static/assets/js/application.js"></script>
<script src="${base}/static/underscore-min.js"></script>
</body>
</html>