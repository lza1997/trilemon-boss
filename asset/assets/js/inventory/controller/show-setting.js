/**
 * 仓库计划编辑
 */
define(function(require, exports, module) {
    var EditController = ['$scope', 'InventorySetting', '$location', function($scope, InventorySetting, $location) {
        var BANNER_TEXT = {
            regular_shelved: '我下架的',
            never_on_shelf: '从未上架的'
        };
        var WEEK = '周一 周二 周三 周四 周五 周六 周日'.split(' ');

        $scope.setting = InventorySetting.get(function(data) {
            // 数据显示
            if (data.includeBanners) {
                $scope.includeBannersText = _.map(data.includeBanners.split(','), function(v) {
                    return BANNER_TEXT[v];
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

    EditController.template = 'inventory/showSetting';
    EditController.title = '计划详情';
    EditController.navClass = 'inventoryShow';

    module.exports = EditController;
});