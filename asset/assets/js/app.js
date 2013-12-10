//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
define(function() {
    var app = angular.module('app', ['ngRoute', 'ngSanitize', 'ngResource', 'restangular', 'ui.bootstrap', 'common', 'seajs', 'ajax-spinner', 'highchart']);

    app.config(['$routeProvider', '$httpProvider', 'SeajsLazyModuleProvider', function($routeProvider, $httpProvider, SeajsLazyModuleProvider) {

        SeajsLazyModuleProvider.setTilteSuffix(' - Trilemon');
        var shelf = SeajsLazyModuleProvider.create('app/shelf/index');
        var showCase = SeajsLazyModuleProvider.create('app/showcase/index');
        var inventory = SeajsLazyModuleProvider.create('app/inventory/index');
        var rate = SeajsLazyModuleProvider.create('app/rate/index');

        $routeProvider
            .when('/shelf/plan-setting/new', shelf.routeFor('shelf.newPlanSetting'))
            .when('/shelf/plan-setting/:id/filter', shelf.routeFor('shelf.filter', {reloadOnSearch: false}))
            .when('/shelf/plan-setting/:id/edit', shelf.routeFor('shelf.editPlanSetting'))
            .when('/shelf/plan-setting/:id/distribution', shelf.routeFor('shelf.distribution'))
            .when('/shelf/plan-setting', shelf.routeFor('shelf.indexPlanSetting', {reloadOnSearch: false}))
            .when('/shelf', {redirectTo: '/shelf/plan-setting'})

            .when('/showcase/setting/edit', showCase.routeFor('showcase.editSetting'))
            .when('/showcase/showcase-item', showCase.routeFor('showcase.indexShowcase', {reloadOnSearch: false}))
            .when('/showcase/exclude-item', showCase.routeFor('showcase.excludeItem', {reloadOnSearch: false}))
            .when('/showcase/include-item', showCase.routeFor('showcase.includeItem', {reloadOnSearch: false}))
            .when('/showcase', {redirectTo: '/showcase/setting/edit'})

            .when('/inventory/setting/edit', inventory.routeFor('inventory.editSetting'))
            .when('/inventory/setting', inventory.routeFor('inventory.showSetting', {reloadOnSearch: false}))
            .when('/inventory/distribution', inventory.routeFor('inventory.distribution'))
            .when('/inventory', {redirectTo: '/inventory/setting/edit'})

            .when('/rate/comments', rate.routeFor('rate.indexComment'))
            .when('/rate', {redirectTo: '/rate/comments'})

            .otherwise({redirectTo: '/shelf'});
    }]);

    app.run(['SeajsLazyModule', '$templateCache', function(SeajsLazyModule, $templateCache) {
        SeajsLazyModule.init($templateCache);
    }]);

    angular.bootstrap(document.documentElement, [app.name]);
});