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

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', 'SeajsLazyModuleProvider', 'RESTProvider', function($routeProvider, RestangularProvider, $httpProvider, SeajsLazyModuleProvider, RESTProvider) {

    SeajsLazyModuleProvider.setTilteSuffix(' - Trilemon');
    var planSetting = SeajsLazyModuleProvider.create('shelf_js/plan-setting/index');

    $routeProvider
        .when('/plan-setting/new', planSetting.routeFor('planSetting.new'))
        .when('/plan-setting/:id/filter', planSetting.routeFor('planSetting.filter'))
        .when('/plan-setting/:id/edit', planSetting.routeFor('planSetting.edit'))
        .when('/plan-setting', planSetting.routeFor('planSetting.index', {reloadOnSearch: false}))
        .otherwise({redirectTo: '/plan-setting'});


    RestangularProvider.setMethodOverriders(['put', 'delete']);

    $httpProvider.interceptors.push('ajaxSpinner');

    RESTProvider.setURL({
        ITEM: 'shelf/items',
        SELLER_CAT: 'shelf/sellercats',
        PLAN_SETTING: 'shelf/plan-settings'
    });
}]);

app.constant('PLAN_STATUS', {
    WAITING: 0,
    RUNNING: 1,
    PAUSED: 2
});

app.run(['SeajsLazyModule', function(SeajsLazyModule) {
    SeajsLazyModule.init();
}]);