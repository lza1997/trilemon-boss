/**
 * 排除宝贝
 */
define(function(require, exports, module) {
    var ExcludeItemController = ['$scope', 'ShowcaseItemFactory', '$location', '$routeParams', function($scope, ShowcaseItemFactory, $location, $routeParams) {
        var Item = ShowcaseItemFactory.create({
            baseUrl: '/showcase/setting-items',
            transform: true,
            action: {
                name: 'exclude',
                url: '/exclude',
                method: 'PUT'
            }
        });

        // 初始化
        $scope.init = function() {
            $scope.searchKey = $routeParams.key;
            $scope.category = $routeParams.category || 'onsale';
            getItems();
        };


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
        $scope.setExclude = Item.setExclude;
        $scope.setExcludeAll = function(flag) {
            var items = _.where($scope.items, {checked: true});
            if (items.length > 0) {
                Item.setExclude(items, flag);
            }
        };

        // 切换下拉框
        $scope.changeCategory = function(value) {
            getItems({'category': $scope.category, page: 1});
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

            $scope.items = Item.query(options);
            $scope.allChecked = false;
        }

        $scope.init();
    }];

    ExcludeItemController.template = 'showcase/excludeItem';
    ExcludeItemController.title = '排除宝贝';

    module.exports = ExcludeItemController;
});