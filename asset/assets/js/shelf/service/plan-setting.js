/**
 * 计划
 */
define(function(require, exports, module) {
    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/shelf/plan-settings/:id';
        var CHART_URL = '/shelf/plan-settings/chart';
        var PAUSE_URL = URL + '/pause';

        var PlanSetting = $resource(URL, {id: '@id'}, {
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
                transformResponse: $http.defaults.transformResponse.concat([function(data) {
                    var items = data.items;
                    items.totalPage = data.pages;
                    items.currPage = data.pageNum;
                    return items;
                }]),
                interceptor: {
                    response: function(response) {
                        response.resource.totalPage = response.data.totalPage;
                        response.resource.currPage = response.data.currPage;
                        return response.resource;
                    }
                }

            }
        });

        return PlanSetting;
    }];
});