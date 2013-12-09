/**
 * 宝贝列表
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'InventoryItem', 'Confirm', '$location', '$routeParams', function($scope, InventoryItem, Confirm, $location, $routeParams) {
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

        // 立即上架

        // 移除
        $scope.remove = function(item) {
            Confirm.open('确定要移除“' + item.itemTitle + '”？').then(function() {
                item.$remove(function() {
                    $scope.jumpPage($scope.items.currPage).then(function(data) {
                        if (data.length === 0 && $scope.items.currPage > 1) {
                            $scope.jumpPage($scope.items.currPage - 1);
                        }
                    });
                });
            });
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            // 合并 URL 上的参数，并将新参数再次写入 URL
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);

            $scope.items = InventoryItem.query(options);
        }
    }];

    module.exports = IndexController;
});