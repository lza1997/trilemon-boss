/**
 * 计划对应的宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/shelf/plan-settings/:id/items/:numIid';
        var EXCLUDE_URL = URL + '/exclude';

        var PlanItem = $resource(URL, {numIid: '@numIid'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            },
            exclude: {
                method: 'POST',
                url: EXCLUDE_URL
            },
            include: {
                method: 'DELETE',
                url: EXCLUDE_URL
            }
        });

        return PlanItem;
    }];
});