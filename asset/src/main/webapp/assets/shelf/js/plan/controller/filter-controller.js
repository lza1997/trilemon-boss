define(function (require, exports, module) {
    var FilterController = ['$scope', 'Item', 'Plan', function ($scope, Item, Plan) {

        // 初始化
        $scope.init = function () {
            $scope.items = [];
            $scope.excludeIds = [];  // 被排除的宝贝 id
            getItems({}) // 初始化时取第一页数据
        };

        // 搜索
        var searchKey = '';
        $scope.search = function () {
            getItems({key: $scope.searchKey});
            searchKey = $scope.searchKey;
        };

        // 处理分页
        $scope.jumpPage = function (page) {
            getItems({page: page, key: searchKey});
        };

        // 排除
        $scope.setExclude = function (item, flag) {
            item.exclude = flag;
            if (flag) {
                $scope.excludeIds.push(item.numIid);
            } else {
                $scope.excludeIds = _.without($scope.excludeIds, item.numIid);
            }
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            options.cids = Plan.tmpData.sellerCatIds;  // 上一步选中的分类

            Item.getList(options).then(function (data) {
                // 将临时保存的被排除宝贝数据合并
                _.each(data, function (item) {
                    item.exclude = _.contains($scope.excludeIds, item.numIid);
                });

                $scope.items = data;
            })
        };

        $scope.init();
    }];

    FilterController.template = require('../template/filter.html');
    FilterController.title = "筛选宝贝";

    module.exports = FilterController;
});