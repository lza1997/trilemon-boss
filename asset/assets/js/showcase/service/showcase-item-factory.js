/**
 * 生成 Item 类的工厂方法
 * 橱窗下包含三种宝贝：橱窗中的宝贝，规则对应的宝贝（用于排除），所有宝贝（用于固定推荐）
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    // {status:1, item: {...} } => {status:1, ... }
    function transform(data) {
        _.each(data, function(item) {
            _.extend(item, item.item);
            delete item.item;
            return item;
        });
        return data;
    }

    module.exports = ['$resource', '$http', function($resource, $http) {

        // options 示例 {baseUrl: '/items', transform: false }
        var Factory = {
            create: function(options) {
                var itemUrl = options.baseUrl + '/:id';

                var actionConfig = {
                    query: {
                        method: 'GET',
                        isArray: true,
                        transformResponse: paginateResource.createTransform($http),
                        interceptor: {
                            response: paginateResource.responseInterceptor
                        }
                    }
                };

                if (options.transform) {
                    actionConfig.query.transformResponse.push(transform);
                }

                // 新增的 REST 方法
                if (options.action) {
                    var action = options.action;
                    action.url = options.baseUrl + action.url;
                    actionConfig[action.name] = action;
                }

                var Item = $resource(itemUrl, {id: '@numIid'}, actionConfig);

                // 排除与加入的 API
                if (options.action) {
                    var name = options.action.name;
                    // exclude => setExclude
                    var methodName = 'set' + name.charAt(0).toUpperCase() + name.substring(1);
                    // 设置排除
                    Item[methodName] = function(items, flag) {
                        if (!angular.isArray(items)) {
                            items = [items];
                        }
                        var params = {numIids: _.pluck(items, 'numIid')};
                        params[name] = flag;
                        Item[name](params, function() {
                            _.each(items, function(item) {
                                item[name] = flag;
                            });
                        });
                    };
                }

                return Item;
            }
        };

        return Factory;
    }];
});