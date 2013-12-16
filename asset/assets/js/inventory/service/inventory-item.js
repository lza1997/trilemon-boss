/**
 * 仓库对应的宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/inventory/items/:id';
        var LIST_URL = URL + '/list';  // 立刻上架的 URL

        var InventoryItem = $resource(URL, {id: '@itemNumIid'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            },
            list: {
                method: 'POST',
                url: LIST_URL
            }
        });

        InventoryItem.removeFromList = paginateResource.removeFromList;

        return InventoryItem;
    }];
});