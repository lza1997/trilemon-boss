/**
 * 橱窗中的宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/showcase/showcase-items/:id';

        var Item = $resource(URL, {id: '@numIid'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            }
        });

        return Item;
    }];
});