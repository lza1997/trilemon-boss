define(function(require, exports, module) {
    var angular = require('angularjs');
    var ngResource = require('angular-resource');
    var ngRoute = require('angular-route');
    var ngSanitize = require('angular-sanitize');
    var bootstrap = require('bootstrap');
    var ajaxSpinner = require('./ajax-spinner');

    var common = angular.module('common', [
        ngRoute.name,
        ngResource.name,
        ngSanitize.name,
        bootstrap.name,
        ajaxSpinner.name
    ]);

    common.controller(require('./controller/nav'));

    common.factory(require('./factory/confirm'));
    common.factory(require('./factory/flash'));
    common.factory(require('./factory/seller-cat-factory'));
    common.factory(require('./factory/distribution-factory'));
    common.factory(require('./factory/paginate-util'));

    common.filter(require('./filter/distribution-text'));

    // http method override
    common.config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push(['$q', function($q) {
            return {
                'request': function(config) {
                    var method = config.method;
                    if (method === 'DELETE' || method === "PUT") {
                        config.method = 'POST';
                        config.headers['X-HTTP-Method-Override'] = method;
                    }
                    return config || $q.when(config);
                }
            };
        }]);
    }]);

    module.exports = common;
});
