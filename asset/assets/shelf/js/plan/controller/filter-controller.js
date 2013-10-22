define(function(require, exports, module) {
    var FilterController = ['$scope', 'Item', 'Plan', '$location', 'Flash', function($scope, Item, Plan, $location, Flash) {

        // 初始化
        $scope.init = function() {
            // 没有临时的 Plan 数据时跳回页面
            if (!Plan.tmpData) {
                $location.url('/plan/new');
            }

            $scope.items = [];
            $scope.excludeIds = [];  // 被排除的宝贝 id
            $scope.planNewUrl = true;
            getItems(); // 初始化时取第一页数据
        };

        // 搜索
        var searchKey = '';
        $scope.search = function() {
            getItems({key: $scope.searchKey});
            searchKey = $scope.searchKey;
        };

        // 处理分页
        $scope.jumpPage = function(page) {
            getItems({page: page, key: searchKey});
        };

        // 排除
        $scope.setExclude = function(item, flag) {
            item.exclude = flag;
            if (flag) {
                $scope.excludeIds.push(item.numIid);
            }
            else {
                $scope.excludeIds = _.without($scope.excludeIds, item.numIid);
            }
        };

        $scope.save = function() {
            Plan.tmpData.excludeItemIids = $scope.excludeIds.join(',');
            Plan.post(Plan.tmpData).then(function() {
                Flash.success('计划 ' + Plan.tmpData.name + ' 创建成功！');
                $location.url('/plan');
            });
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            options = options || {};
            options.cids = Plan.tmpData.includeCids.split(',');  // 上一步选中的分类

            Item.getList(options).then(function(data) {
                // 将临时保存的被排除宝贝数据合并
                _.each(data, function(item) {
                    item.exclude = _.contains($scope.excludeIds, item.numIid);
                });

                $scope.items = data;
            });
        }

        $scope.init();
    }];

    FilterController.template = require('../template/filter.html');
    FilterController.title = "筛选宝贝";
    FilterController.navClass = "planNew";

    module.exports = FilterController;
});