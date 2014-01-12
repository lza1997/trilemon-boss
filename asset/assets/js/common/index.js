define(function(require, exports, module) {
    var angular = require('angularjs');
    var ngAnimate = require('angular-animate');
    var ngResource = require('angular-resource');
    var ngRoute = require('angular-route');
    var ngSanitize = require('angular-sanitize');
    var bootstrap = require('angular/bootstrap/0.0.1/index');
    var ajaxSpinner = require('./ajax-spinner');

    var common = angular.module('common', [
        ngAnimate.name,
        ngRoute.name,
        ngResource.name,
        ngSanitize.name,
        bootstrap.name,
        ajaxSpinner.name
    ]);

    common.controller(require('./controller/nav'));

    common.factory(require('./service/confirm'));
    common.factory(require('./service/flash'));
    common.factory(require('./service/seller-cat-factory'));
    common.factory(require('./service/distribution-factory'));

    common.filter(require('./filter/distribution-text'));

    module.exports = common;
});
