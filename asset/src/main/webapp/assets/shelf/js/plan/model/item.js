/**
 * 商品（宝贝）
 */
define(function (require, exports, module) {
    var URL = '/shelf/items';

    var Item = ['$http', '$q', function ($http, $q) {

        var Model = {};

        // 获取列表，带分页结构
        Model.getList = function (options) {
            var defer = $q.defer();

            options = _.defaults(options || {}, {
                page: 1,
                key: '',
                cids: []
            });

            $http({
                method: 'GET',
                url: URL,
                params: options
            }).success(function (data) {
                    var tmp = data.items;

                    tmp.totalPage = data.pages;
                    tmp.currPage = data.pageNum;

                    defer.resolve(tmp);
                });

            return defer.promise;
        };

        return Model;
    }];

    module.exports = Item;
});