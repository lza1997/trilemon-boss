/**
 * 为转换分页结果提供的通用方法
 */
define(function(require, exports, module) {

    exports.createTransform = function($http) {
        return $http.defaults.transformResponse.concat([function(data) {
            var items = data.items;
            items.totalPage = data.pages;
            items.currPage = data.pageNum;
            return items;
        }]);
    };

    exports.responseInterceptor = function(response) {
        response.resource.totalPage = response.data.totalPage;
        response.resource.currPage = response.data.currPage;
        return response.resource;
    };
});