define(function (require, exports, module) {
    var FilterController = ['$scope', 'Item', function ($scope, Item) {
        $scope.items = [];
        $scope.excludeIds = [];

        $scope.jumpPage = function (page) {
            Item.getList(page).then(function (data) {
                // 将临时保存的排除宝贝写入
                _.each(data, function (item) {
                    if (_.contains($scope.excludeIds, item.numIid)) {
                        item.exclude = true;
                    }
                });

                $scope.items = data;

            });
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

        // 初始化时取第一页数据
        $scope.jumpPage();
    }];

    FilterController.template = require('./filter.html');
    FilterController.title = "筛选宝贝";

    module.exports = FilterController;
});