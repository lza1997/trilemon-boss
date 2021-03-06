/**
 * 计划
 */
define(function(require, exports, module) {
    var _ = require('_');

    module.exports = {
        'PlanSetting': ['$resource', '$http', 'PaginateUtil', function($resource, $http, PaginateUtil) {
            var BASE_URL = '/shelf/plan-settings';
            var PLAN_URL = BASE_URL + '/:id';
            var PAUSE_URL = PLAN_URL + '/pause';
            var CHART_URL = BASE_URL + '/chart';

            var PlanSetting = $resource(PLAN_URL, {id: '@id'}, {
                update: {
                    method: 'PUT'
                },
                pause: {
                    method: 'POST',
                    url: PAUSE_URL
                },
                resume: {
                    method: 'DELETE',
                    url: PAUSE_URL
                },
                chart: {
                    method: 'GET',
                    url: CHART_URL,
                    isArray: true,
                    transformResponse: $http.defaults.transformResponse.concat([function(data) {
                        return _.map(data, function(i) {
                            return {value: i};
                        });
                    }])
                },
                query: {
                    method: 'GET',
                    isArray: true,
                    transformResponse: PaginateUtil.createTransform(),
                    interceptor: {
                        response: PaginateUtil.responseInterceptor
                    }
                }
            });

            PlanSetting.removeFromList = PaginateUtil.removeFromList;

            return PlanSetting;
        }]
    };
});