/**
 * 排除宝贝
 */
define(function(require, exports, module) {
    var ExcludeItemController = ['$scope', 'ShowcaseSettingItem', '$location', '$routeParams', function($scope, ShowcaseSettingItem, $location, $routeParams) {
        $scope.searchKey = $routeParams.key;
        $scope.category = $routeParams.category || 'onsale';

        // 全选与单独选择的联动
        $scope.toggleCheckedAll = function() {
            _.each($scope.items, function(item) {
                item.checked = $scope.allChecked;
            });
        };
        $scope.toggleChecked = function() {
            $scope.allChecked = _.all($scope.items, function(item) {
                return item.checked;
            });
        };

        // 设置排除
        $scope.setExclude = ShowcaseSettingItem.setExclude;

        $scope.setExcludeAll = function(flag) {
            var items = _.where($scope.items, {checked: true});
            if(items.length > 0){
                ShowcaseSettingItem.setExclude(items, flag);
            }
        };

        // 切换下拉框即请求数据，初始化时也会执行一次
        $scope.$watch('category', function(value) {
            getItems({'category': value, page: 1});
        });
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
            options = _.defaults(options, $routeParams);
            $location.search(options);

            $scope.items = ShowcaseSettingItem.query(options);
            $scope.allChecked = false;
        }
    }];

    ExcludeItemController.template = 'showcase/excludeItem';
    ExcludeItemController.title = '排除宝贝';

    module.exports = ExcludeItemController;
});