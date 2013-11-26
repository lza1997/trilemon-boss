/**
 * 设置固定推荐
 */
define(function(require, exports, module) {

    var IncludeItemController = ['$scope', 'ShowcaseItemFactory', '$routeParams', '$location', function($scope, ShowcaseItemFactory, $routeParams, $location) {

        var Item = ShowcaseItemFactory.create({
            baseUrl: '/showcase/items',
            transform: true,
            action: {
                name: 'include',
                url: '/include',
                method: 'PUT'
            }
        });

        // 初始化
        $scope.init = function() {
            $scope.searchKey = $routeParams.key;
            $scope.category = $routeParams.category || 'onsale';
            $scope.order = $routeParams.order;
            $scope.tab = $routeParams.tab || 'all';
            $scope.tabs = [
                {name: '全部宝贝', value: 'all'},
                {name: '固定推荐的宝贝', value: 'include'},
            ];
            getItems();
        };

        // 切换 tab
        $scope.selectTab = function(tab) {
            $scope.tab = tab.value;
            getItems({
                tab: tab.value,
                page: 1,
                key: '',
                order: '',
                category: ''
            });
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
        $scope.setInclude = Item.setInclude;

        $scope.setIncludeAll = function(flag) {
            var items = _.where($scope.items, {checked: true});
            if (items.length > 0) {
                Item.setInclude(items, flag);
            }
        };

        // 切换分类
        $scope.changeCategory = function() {
            getItems({category: $scope.category, page: 1});
        };

        // 搜索
        $scope.search = function() {
            getItems({key: $scope.searchKey, page: 1});
        };

        // 切换排序
        $scope.changeOrder = function() {
            $scope.order = $scope.order === 'desc' ? 'asc' : 'desc';
            getItems({order: $scope.order});
        };

        // 分页
        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            options = _.defaults(options || {}, $routeParams);
            // remove falsy prop
            _.each(_.keys(options), function(k) {
                if (!options[k]) {
                    delete options[k];
                }
            });

            $location.search(options);

            $scope.items = Item.query(options);
            $scope.allChecked = false;
        }

        $scope.init();
    }];

    IncludeItemController.template = 'showcase/includeItem';
    IncludeItemController.title = '固定推荐';
    IncludeItemController.navClass = 'showcaseInclude';

    module.exports = IncludeItemController;
});