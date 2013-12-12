/**
 * 仓库计划详情页
 */
define(function(require, exports, module) {
    var ShowController = ['$scope', 'InventorySetting', function($scope, InventorySetting) {
        $scope.BANNER = {
            'off_shelf': '我下架的',
            'never_on_shelf': '从未上架的'
        };
        $scope.STATUS = {
            0: '未上架',
            1: '已上架'
        };
        var WEEK = '周一 周二 周三 周四 周五 周六 周日'.split(' ');

        $scope.setting = InventorySetting.get(function(data) {
            // 数据显示
            if (data.includeBanners) {
                $scope.includeBannersText = _.map(data.includeBanners.split(','), function(v) {
                    return $scope.BANNER[v];
                });
            }
            $scope.distributionText = [];
            _.each(data.distributionMap, function(v, k) {
                if (_.any(v)) {
                    $scope.distributionText.push(WEEK[k - 1]);
                }
            });
        });

        // 停用或开启
        $scope.togglePaused = function() {
            var method = $scope.setting.paused ? '$resume' : '$pause';
            $scope.setting[method]();
        };
    }];

    ShowController.template = 'inventory/showSetting';
    ShowController.title = '计划详情 - 仓库宝贝上架';
    ShowController.navClass = 'inventoryShow';

    module.exports = ShowController;
});