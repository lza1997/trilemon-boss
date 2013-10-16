/**
 * 卖家的类目
 */
define(function (require, exports, module) {
    var URL = 'trilemon-360boss-shelf/sellercats';

    var Sellercat = ['Restangular', '$q', function (Restangular, $q) {

        var Model = Restangular.all(URL);

        // 服务器的列表转换成树状结构
        Model.getTree = function () {
            var defer = $q.defer();
            Model.getList().then(function (data) {
                // 一级目录
                var cats = _.where(data, {parentCid: 0});

                // 补充二级目录
                _.each(cats, function (cat) {
                    cat.children = _.where(data, {parentCid: cat.cid});
                });

                defer.resolve(cats);
            });
            return defer.promise;
        };

//        Model.getList = function () {
//
//        };

        return Model;
    }];

    module.exports = Sellercat;
});