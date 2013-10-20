var common = angular.module('common', []);
var app = angular.module('app', ['ngAnimate', 'ngRoute', 'restangular', 'ui.bootstrap.dropdownToggle', 'common']);

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
SeajsRoute.setApp(app);

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', function($routeProvider, RestangularProvider, $httpProvider) {
    $routeProvider
        .when('/plan/new', SeajsRoute.createRoute({
            controller: 'plan.new',
            module: 'shelf_js/plan/index'
        }))
        .when('/plan/filter', SeajsRoute.createRoute({
            controller: 'plan.filter',
            module: 'shelf_js/plan/index'
        }))
        .when('/plan', SeajsRoute.createRoute({
            controller: 'plan.index',
            module: 'shelf_js/plan/index'
        }))
        .otherwise({redirectTo: '/plan/new'});


    RestangularProvider.setMethodOverriders(['post', 'delete']);

    $httpProvider.interceptors.push('ajaxSpinner');
}]);