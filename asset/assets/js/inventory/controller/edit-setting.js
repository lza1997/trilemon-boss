/**
 * 仓库计划编辑
 */
define(function(require, exports, module) {
    var EditController = ['$scope', 'InventorySetting', 'InventoryItemNum', '$location', function($scope, InventorySetting, InventoryItemNum, $location) {

        $scope.includeBanners = {};
        $scope.itemNum = InventoryItemNum.get();
        $scope.setting = InventorySetting.get(function(data) {
            // 回填仓库类型
            if (data.includeBanners) {
                _.each(data.includeBanners.split(','), function(key) {
                    $scope.includeBanners[key] = true;
                });
            }
        });

        $scope.save = function() {
            // 保存选择的仓库类型
            var arr = [];
            _.each($scope.includeBanners, function(v, k) {
                if (v) {
                    arr.push(k);
                }
            });
            $scope.setting.includeBanners = arr.join(',');
            $scope.setting.$update(function(){
                $location.url('/inventory/setting');
            });
        };

        // 停用或开启
        $scope.togglePaused = function() {
            var method = $scope.setting.paused ? '$resume' : '$pause';
            $scope.setting[method]();
        };
    }];

    EditController.template = 'inventory/editSetting';
    EditController.title = '修改计划';
    EditController.navClass = 'inventoryEdit';

    module.exports = EditController;
});