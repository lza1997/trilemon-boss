/**
 * ajax 指示器
 */
angular.module('ajax-spinner', []).config(['$httpProvider', function($httpProvider) {

        $httpProvider.interceptors.push(['$rootScope', '$q', '$timeout', function($rootScope, $q, $timeout) {
            var t;

            return {
                'request': function(config) {
                    t = $timeout(function() {
                        $rootScope.ajaxing = true;
                        $rootScope.ajaxingMethod = config.method;
                    }, 100);

                    return config || $q.when(config);
                },

                'response': function(response) {
                    $timeout.cancel(t);
                    $rootScope.ajaxing = false;
                    return response || $q.when(response);
                }
            };
        }]);
    }]).directive('ajaxSpinner', function() {
        return {
            restrict: 'EA',
            template: '<div class="ajax-spinner" ng-class="{show: ajaxing}">' +
                '<i class="icon-spinner icon-spin"></i> {{ajaxingMethod == "GET" ? "载入中" : "处理中"}}...</div>'
        };
    });