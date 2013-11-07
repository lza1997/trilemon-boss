var app = angular.module('app', ['ngRoute', 'ngSanitize', 'restangular', 'ui.bootstrap', 'common', 'seajs', 'ajax-spinner', 'highchart']);

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', 'SeajsLazyModuleProvider', 'RESTProvider', function($routeProvider, RestangularProvider, $httpProvider, SeajsLazyModuleProvider, RESTProvider) {

    SeajsLazyModuleProvider.setTilteSuffix(' - Trilemon');
    var shelf = SeajsLazyModuleProvider.create('app/shelf/index');
    var showCase = SeajsLazyModuleProvider.create('app/showcase/index');

    $routeProvider
        .when('/shelf/plan-setting/new', shelf.routeFor('shelf.newPlanSetting'))
        .when('/shelf/plan-setting/:id/filter', shelf.routeFor('shelf.filter'))
        .when('/shelf/plan-setting/:id/edit', shelf.routeFor('shelf.editPlanSetting'))
        .when('/shelf/plan-setting/:id/distribution', shelf.routeFor('shelf.distribution'))
        .when('/shelf/plan-setting', shelf.routeFor('shelf.indexPlanSetting', {reloadOnSearch: false}))
        .when('/shelf', {redirectTo: '/shelf/plan-setting'})

        .when('/showcase/rule/edit', showCase.routeFor('showcase.editRule'))
        .when('/showcase', {redirectTo: '/showcase/rule/edit'})

        .otherwise({redirectTo: '/shelf'});


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