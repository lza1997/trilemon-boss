/**
 * 商品（宝贝）
 */
define(function (require, exports, module) {
    var URL = '/trilemon-360boss-shelf/items';

    var Sellercat = ['$http', '$q', function ($http, $q) {

        var Model = {};

        // 获取列表，带分页结构
        Model.getList = function (page) {
            var defer = $q.defer();

            page = page || 1;
            $http({
                method: 'GET',
                url: URL + '?page_num=' + page
            }).success(function (data) {
                var tmp = data.items;

                tmp.totalPage = data.pages;
                tmp.currPage = data.pageNum;

                defer.resolve(tmp);
            });

            return defer.promise;
        }

        return Model;
    }];

    module.exports = Sellercat;
});