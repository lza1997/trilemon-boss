<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <link href="${base}/static/bootstrap/3.0.0/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/static/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/static/fortawesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/static/assets/css/application.css" rel="stylesheet">
    <link href="${base}/static/assets/css/shelf.css" rel="stylesheet">
    <link href="${base}/static/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">

    <!--[if IE 7]>
    <link href="${base}/static/fortawesome/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="${base}/static/html5shiv.js"></script>
    <script src="${base}/static/respond.min.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="${base}/assets/ico/favicon.png">
</head>

<body>
<#include "/WEB-INF/layouts/header.ftl">

<div class="container">
${body}
</div>

<#include "/WEB-INF/layouts/footer.ftl">
<script src="${base}/static/jquery/jquery-1.10.2.min.js"></script>
<script src="${base}/static/moment/moment.js" type="text/javascript"></script>
<script src="${base}/static/moment/zh-cn.js" type="text/javascript"></script>
<script src="${base}/static/bootstrap/3.0.0/js/bootstrap.js"></script>
<script src="${base}/static/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${base}/static/bootstrap-select/bootstrap-select.min.js"></script>
<script src="${base}/static/underscore-min.js"></script>
<script src="${base}/static/angular.min.js"></script>
<script src="${base}/static/bootstrap-tagsinput/bootstrap-tagsinput-angular.js" type="text/javascript"></script>
<script src="${base}/static/bootstrap-tagsinput/bootstrap-tagsinput.min.js" type="text/javascript"></script>
<script src="${base}/static/bootstrap-tagsinput/bsTagsInput.js" type="text/javascript"></script>
<script src="${base}/static/assets/js/application.js"></script>
<script src="${base}/static/assets/js/shelf.js"></script>
</body>
</html>