/**
 * 宝贝分类
 */
define(function(require, exports, module) {
    module.exports = ['$resource', '$http', '$sce', function($resource, $http, $sce) {
        var URL = '/poster/sellercats';

        var SellerCat = $resource(URL, null, {
            query: {
                method: 'GET',
                isArray: true,
                interceptor: {
                    // 整理服务器数据，进行一些预处理
                    'response': function(response) {
                        var data = response.resource;

                        // 服务器数据再组装
                        _.each(data, function(item) {
                            _.extend(item, item.sellerCat);
                            delete item.sellerCat;
                        });

                        // 添加 optionName 属性，用于绘制 select
                        var groups = _.groupBy(data, function(cat) {
                            return cat.parentCid;
                        });
                        _.each(groups, function(group, parentCid) {
                            if (parentCid !== '0') {
                                _.each(group, function(cat, index) {
                                    if (index === group.length - 1) {
                                        cat.name = '└  ' + cat.name;
                                    }
                                    else {
                                        cat.name = '├ ' + cat.name;
                                    }
                                });
                            }
                        });

                        return response.resource;
                    }
                }
            }
        });

        return SellerCat;
    }];
});