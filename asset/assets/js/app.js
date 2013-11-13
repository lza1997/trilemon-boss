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

        .when('/showcase/setting/edit', showCase.routeFor('showcase.editSetting'))
        .when('/showcase/showcase-item', showCase.routeFor('showcase.indexShowcase'))
        .when('/showcase/exclude-item', showCase.routeFor('showcase.excludeItem'))
        .when('/showcase', {redirectTo: '/showcase/setting/edit'})

        .otherwise({redirectTo: '/shelf'});


    RestangularProvider.setMethodOverriders(['put', 'delete']);

    RESTProvider.setURL({
        ITEM: 'shelf/items',
        SHELF_SELLERCAT: 'shelf/sellercats',
        PLAN_SETTING: 'shelf/plan-settings',
        SHOWCASE_SETTING: 'showcase/settings',
        SHOWCASE_SELLERCAT: 'showcase/sellercats',
        SHOWCASE_ITEM: 'showcase/showcase-items',
        SHOWCASE_SETTING_ITEM: 'showcase/setting-items'
    });
}]);

app.run(['SeajsLazyModule', '$templateCache', function(SeajsLazyModule, $templateCache) {
    SeajsLazyModule.init($templateCache);
}]);