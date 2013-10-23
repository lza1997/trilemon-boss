var app = angular.module('app', ['ngAnimate', 'ngRoute', 'restangular', 'ui.bootstrap', 'common', 'seajs']);

app.factory('ajaxSpinner', ['$rootScope', '$q', function($rootScope, $q) {
    return {
        'request': function(config) {
            $rootScope.ajaxing = true;
            return config || $q.when(config);
        },
        'response': function(response) {
            $rootScope.ajaxing = false;
            return response || $q.when(response);
        }
    };
}]);

// 带分页处理的 restangular
app.factory('RestPageangular', function(Restangular) {
    return Restangular.withConfig(function(config) {
        config.setResponseExtractor(function(data, operation, what, url, response, deferred) {
            if (operation === 'getList') {
                var items = data.items;
                items.totalPage = data.pages;
                items.currPage = data.pageNum;
                return items;
            }
            else {
                return data;
            }
        });
    });
});

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', 'SeajsLazyModuleProvider', function($routeProvider, RestangularProvider, $httpProvider, SeajsLazyModuleProvider) {

    SeajsLazyModuleProvider.setTilteSuffix(' - Trilemon');
    var planSetting = SeajsLazyModuleProvider.create('shelf_js/plan-setting/index');

    $routeProvider
        .when('/plan-setting/new', planSetting.routeFor('planSetting.new'))
        .when('/plan-setting/filter', planSetting.routeFor('planSetting.filter'))
        .when('/plan-setting/:id/edit', planSetting.routeFor('planSetting.edit'))
        .when('/plan-setting', planSetting.routeFor('planSetting.index'))
        .otherwise({redirectTo: '/plan-setting'});


    RestangularProvider.setMethodOverriders(['put', 'delete']);

    $httpProvider.interceptors.push('ajaxSpinner');
}]);

app.run(['SeajsLazyModule',function(SeajsLazyModule){
    SeajsLazyModule.init();
}]);