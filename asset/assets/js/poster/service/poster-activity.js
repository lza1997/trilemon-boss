/**
 * 海报活动，就是用户创建的海报
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    // 服务器数据再组装，针对宝贝字段
    function transformItem(items) {
        _.each(items, function(item) {
            _.extend(item, item.item);
            delete item.item;
        });
    }

    module.exports = ['$resource', '$http', function($resource, $http) {
        var URL = '/poster/activities/:id';
        var ITEM_URL = URL + '/items'; // 修改选择的宝贝
        var HTML_URL = URL + '/html';  // 修改海报的 HTML, 标题
        var PUBLISH_SETTING_URL = URL + '/publish-setting';  // 修改投放设置
        var PUBLISH_URL = URL + '/publish'; // 投放活动

        var PosterActivity = $resource(URL, {id: '@id'}, {
            query: {
                method: 'GET',
                isArray: true,
                transformResponse: paginateResource.createTransform($http),
                interceptor: {
                    response: paginateResource.responseInterceptor
                }
            },

            get: {
                method: 'GET',
                interceptor: {
                    response: function(response) {
                        var data = response.resource;
                        transformItem(data.activityItems);
                        transformItem(data.publishItems);
                        return data;
                    }
                }
            },

            saveItems: {
                method: 'PUT',
                url: ITEM_URL
            },

            saveHTML: {
                method: 'PUT',
                url: HTML_URL
            },

            savePublish: {
                method: 'PUT',
                url: PUBLISH_SETTING_URL
            },

            save: {
                method: 'POST',
                url: URL
            },

            publish: {
                method: 'POST',
                url: PUBLISH_URL
            },

            unPublish: {
                method: 'DELETE',
                url: PUBLISH_URL
            }
        });

        PosterActivity.refreshCurrPage = paginateResource.refreshCurrPage;

        return PosterActivity;
    }];
});