/**
 * 仓库计划编辑
 */
define(function(require, exports, module) {
    var EditController = ['$scope', 'InventorySetting', 'InventoryItem', '$location', '$routeParams', function($scope, InventorySetting, InventoryItem, $location, $routeParams) {
        $scope.BANNER = {
            'regular_shelved': '我下架的',
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

        // 初始化获取宝贝
        $scope.init = function() {
            $scope.searchKey = $routeParams.key;
            $scope.banner = $routeParams.banner;
            $scope.status = $routeParams.status;
            getItems();
        };

        $scope.init();

        // 切换下拉框
        $scope.changeBanner = function() {
            getItems({'banner': $scope.banner || '', page: 1});
        };
        $scope.changeStatus = function() {
            getItems({'status': $scope.status || '', page: 1});
        };
        // 搜索
        $scope.search = function() {
            getItems({'key': $scope.searchKey, page: 1});
        };
        // 分页
        $scope.jumpPage = function(page) {
            getItems({'page': page});
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            // 合并 URL 上的参数，并将新参数再次写入 URL
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);

            $scope.items = InventoryItem.query(options);
        }

    }];

    EditController.template = 'inventory/showSetting';
    EditController.title = '计划详情';
    EditController.navClass = 'inventoryShow';

    module.exports = EditController;
});