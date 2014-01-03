/**
 * 海报活动，就是用户创建的海报
 */
define(function(require, exports, module) {
    var paginateResource = require('../../common/paginate-resource');

    // 服务器数据再组装
    function transformItem(items) {
        _.each(items, function(item) {
            _.extend(item, item.item);
            delete item.item;
        });
    }

    module.exports = ['$resource', '$http', function($resource, $http) {
        var BASE_URL = '/poster/activities';
        var URL = BASE_URL + '/:id';
        var HTML_URL = URL + '/html';

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
                        return data;
                    }
                }
            },

            saveHTML: {
                method: 'PUT',
                url: HTML_URL
            },

            save: {
                method: 'POST',
                url: URL
            }
        });

        PosterActivity.refreshCurrPage = paginateResource.refreshCurrPage;

        return PosterActivity;
    }];
});