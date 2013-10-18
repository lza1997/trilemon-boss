var app = angular.module('app', ['ngAnimate', 'ngRoute', 'restangular', 'ui.bootstrap.dropdownToggle', 'common']);

app.factory('ajaxSpinner', ['$rootScope', '$q', function ($rootScope, $q) {
    return {
        'request': function (config) {
            $rootScope.ajaxing = true;
            return config || $q.when(config);
        },
        'response': function (response) {
            $rootScope.ajaxing = false;
            return response || $q.when(response);
        }
    };
}]);

SeajsRoute.setApp(app);

app.config(['$routeProvider', 'RestangularProvider', '$httpProvider', function ($routeProvider, RestangularProvider, $httpProvider) {
    $routeProvider
        .when('/plan/new', SeajsRoute.createRoute({
            controller: 'plan.new',
            module: 'shelf_js/plan/index'
        }))
        .when('/plan/filter', SeajsRoute.createRoute({
            controller: 'plan.filter',
            module: 'shelf_js/plan/index'
        }))
        .otherwise({redirectTo: '/plan/new'});


    RestangularProvider.setRequestSuffix('.json');
    RestangularProvider.setMethodOverriders(['post', 'delete']);

    $httpProvider.interceptors.push('ajaxSpinner');


}]);