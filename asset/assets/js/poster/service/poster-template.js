/**
 * 店铺类型
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/poster/templates/:id';
        var FAV_URL = URL + '/fav'

        var PosterTemplate = $resource(URL, {id: '@id'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            },
            fav: {
                url: FAV_URL,
                method: 'POST'
            },
            unfav: {
                url: FAV_URL,
                method: 'DELETE'
            }
        });

        return PosterTemplate;
    }];
});