/**
 * 计划
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
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
                    return data.map(function(i) {
                        return {value: i};
                    });
                }])
            },
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            }
        });

        return PlanSetting;
    }];
});