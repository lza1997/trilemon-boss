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
define(function(require, exports, module) {
    var angular = require('angularjs');
    var SeajsLazyAngular = require('seajs-lazy-angular');
    var common = require('./common/index');

    var app = angular.module('app', [common.name]);

    if (window.IE7_FIX_CONFIG) {
        app.config(window.IE7_FIX_CONFIG);
    }

    app.config(SeajsLazyAngular.cacheInternals);

    SeajsLazyAngular.patchAngular();
    SeajsLazyAngular.setResolveCallback(['$rootScope', 'controller', function($rootScope, controller) {
        $rootScope.title = controller.title + ' - Trilemon';
        $rootScope.navClass = controller.navClass;
    }]);

    app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {

        //        var showCase = SeajsLazyModuleProvider.create('app/showcase/index');
        //        var inventory = SeajsLazyModuleProvider.create('app/inventory/index');
        //        var rate = SeajsLazyModuleProvider.create('app/rate/index');
        //        var poster = SeajsLazyModuleProvider.create('app/poster/index');

        var shelf = SeajsLazyAngular.createLazyStub('app/shelf/index');

        $routeProvider
            .when('/shelf/plan-setting/new', shelf.createRoute('./controller/form'))
            .when('/shelf/plan-setting/:id/edit', shelf.createRoute('./controller/form'))
            .when('/shelf/plan-setting/:id/filter', shelf.createRoute('./controller/filter', {reloadOnSearch: false}))
            .when('/shelf/plan-setting/:id/distribution', shelf.createRoute('./controller/distribution'))
            .when('/shelf/plan-setting', shelf.createRoute('./controller/index-plan-setting', {reloadOnSearch: false}))
            .when('/shelf', {redirectTo: '/shelf/plan-setting'})
            //
            //            .when('/showcase/setting/edit', showCase.routeFor('showcase.editSetting'))
            //            .when('/showcase/showcase-item', showCase.routeFor('showcase.indexShowcase', {reloadOnSearch: false}))
            //            .when('/showcase/exclude-item', showCase.routeFor('showcase.excludeItem', {reloadOnSearch: false}))
            //            .when('/showcase/include-item', showCase.routeFor('showcase.includeItem', {reloadOnSearch: false}))
            //            .when('/showcase', {redirectTo: '/showcase/setting/edit'})
            //
            //            .when('/inventory/setting/edit', inventory.routeFor('inventory.editSetting'))
            //            .when('/inventory/setting', inventory.routeFor('inventory.showSetting', {reloadOnSearch: false}))
            //            .when('/inventory/distribution', inventory.routeFor('inventory.distribution'))
            //            .when('/inventory', {redirectTo: '/inventory/setting/edit'})
            //
            //            .when('/rate/comments', rate.routeFor('rate.indexComment'))
            //            .when('/rate/filter-buyer', rate.routeFor('rate.filterBuyer'))
            //            .when('/rate/buyer-rates', rate.routeFor('rate.indexBuyerRate', {reloadOnSearch: false}))
            //            .when('/rate', {redirectTo: '/rate/comments'})
            //
            //            .when('/poster/category', poster.routeFor('poster.category'))
            //            .when('/poster/select-template', poster.routeFor('poster.indexTemplate', {reloadOnSearch: false}))
            //            .when('/poster/template', poster.routeFor('poster.indexTemplate', {reloadOnSearch: false}))
            //            .when('/poster/select-item', poster.routeFor('poster.selectItem', {reloadOnSearch: false}))
            //            .when('/poster/activity/:id/preview', poster.routeFor('poster.preview'))
            //            .when('/poster/activity/:id/publish', poster.routeFor('poster.publish'))
            //            .when('/poster/activity', poster.routeFor('poster.indexActivity', {reloadOnSearch: false}))
            //            .when('/poster', {redirectTo: '/poster/category'})

            .otherwise({redirectTo: '/shelf'});

        $httpProvider.interceptors.push(['$q', function($q) {
            return {
                'responseError': function(responseError) {
                    if (responseError.status >= 500) {
                        alert('出错啦！');
                        return $q.reject(responseError);
                    }
                }
            };
        }]);
    }]);

    app.constant({
        'datepickerConfig': {
            dayFormat: 'dd',
            monthFormat: 'MMMM',
            yearFormat: 'yyyy',
            dayHeaderFormat: 'EEE',
            dayTitleFormat: 'yyyy年 MMMM',
            monthTitleFormat: 'yyyy',
            showWeeks: false,
            startingDay: 0,
            yearRange: 20,
            minDate: null,
            maxDate: null
        },
        'datepickerPopupConfig': {
            dateFormat: 'yyyy-MM-dd',
            closeOnDateSelection: true,
            appendToBody: false,
            showButtonBar: false
        }
    });

    angular.bootstrap(document.documentElement, [app.name]);
});