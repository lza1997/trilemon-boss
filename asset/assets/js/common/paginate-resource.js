/**
 * 为转换分页结果提供的通用方法
 */
define(function(require, exports, module) {

    exports.createTransform = function($http) {
        return $http.defaults.transformResponse.concat([function(data, header) {
            if (data.items && angular.isArray(data.items)) {
                var items = data.items;
                items.totalPage = data.pages;
                items.currPage = data.pageNum;
                return items;
            }
            else {
                return data;
            }
        }]);
    };

    exports.responseInterceptor = function(response) {
        response.resource.totalPage = response.data.totalPage;
        response.resource.currPage = response.data.currPage;
        return response.resource;
    };

    // 从结果集中移除某个 item
    exports.removeFromList = function(item, array, getDataFn) {
        item.$remove(function() {
            exports.refreshCurrPage(array.currPage, getDataFn);
        });
    };

    // 刷新当前页，如果当前页无数据则进入上一页
    exports.refreshCurrPage = function(currPage, getDataFn) {
        // 移除完毕后刷新当前页，如果当前页无数据则进入上一页
        getDataFn({page: currPage}).then(function(data) {
            if (data.length === 0 && currPage > 1) {
                getDataFn({page: currPage - 1});
            }
        });
    };

});