/**
 * 宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    function transform(data) {
        _.each(data, function(item) {
            _.extend(item, item.item);
            delete item.item;
            return item;
        });
        return data;
    }

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/poster/items/:numIid';

        var PosterItem = $resource(URL, {numIid: '@numIid'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http).concat(transform),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            }
        });

        return PosterItem;
    }];
});