var app = angular.module('app', ['ngAnimate', 'ngRoute', 'ngSanitize', 'restangular', 'ui.bootstrap', 'common', 'seajs', 'ajax-spinner', 'highchart']);

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', 'SeajsLazyModuleProvider', 'RESTProvider', function($routeProvider, RestangularProvider, $httpProvider, SeajsLazyModuleProvider, RESTProvider) {

    SeajsLazyModuleProvider.setTilteSuffix(' - Trilemon');
    var planSetting = SeajsLazyModuleProvider.create('shelf_js/plan-setting/index');

    $routeProvider
        .when('/plan-setting/new', planSetting.routeFor('planSetting.new'))
        .when('/plan-setting/:id/filter', planSetting.routeFor('planSetting.filter'))
        .when('/plan-setting/:id/edit', planSetting.routeFor('planSetting.edit'))
        .when('/plan-setting/:id/distribution', planSetting.routeFor('planSetting.distribution'))
        .when('/plan-setting', planSetting.routeFor('planSetting.index', {reloadOnSearch: false}))
        .otherwise({redirectTo: '/plan-setting'});


    RestangularProvider.setMethodOverriders(['put', 'delete']);

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

app.run(['SeajsLazyModule', '$templateCache', function(SeajsLazyModule, $templateCache) {
    SeajsLazyModule.init($templateCache);
}]);