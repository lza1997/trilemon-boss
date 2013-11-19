/**
 * 规则对应的宝贝
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    // {status:1, item: {...} } => {status:1, ... }
    function transform(data) {
        _.extend(data, data.item);
        delete data.item;
        return data;
    }

    module.exports = ['$resource', '$http', function($resource, $http) {
        var BASE_URL = '/showcase/setting-items';
        var ITEMS_URL = BASE_URL + '/:id';
        var EXCLUDE_URL = BASE_URL + '/exclude';

        var Item = $resource(ITEMS_URL, {id: '@numIid'}, {
            include: {
                method: 'DELETE',
                url: EXCLUDE_URL
            },
            exclude: {
                method: 'POST',
                url: EXCLUDE_URL
            },
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http).concat([function(data) {
                    _.each(data, function(item) {
                        transform(item);
                    });
                    return data;
                }]),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            }
        });

        // 设置排除
        Item.setExclude = function(items, flag) {
            if (!angular.isArray(items)) {
                items = [items];
            }
            var method = flag ? 'exclude' : 'include';
            Item[method]({numIids: _.pluck(items, 'numIid')}, function() {
                _.each(items, function(item) {
                    item.exclude = flag;
                });
            });
        };

        return Item;
    }];
});