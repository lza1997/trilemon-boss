/**
 * 仓库对应的宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/inventory/items/:id';
        var EXCLUDE_URL = URL + '/exclude';

        var InventoryItem = $resource(URL, {id: '@id'}, {
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

        return InventoryItem;
    }];
});