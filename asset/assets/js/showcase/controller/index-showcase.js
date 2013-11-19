/**
 * 橱窗宝贝
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'ShowcaseItemFactory', 'ShowcaseSetting', '$location', '$routeParams', function($scope, ShowcaseItemFactory, ShowcaseSetting, $location, $routeParams) {

        var Item = ShowcaseItemFactory.create({baseUrl: '/showcase/showcase-items'});

        $scope.searchKey = $routeParams.key;
        $scope.setting = ShowcaseSetting.get();
        getItems(); // 初始化时取第一页数据

        // 搜索
        $scope.search = function() {
            getItems({key: $scope.searchKey, page: 1});
        };

        // 分页
        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);
            $scope.items = Item.query(options);
        }
    }];

    IndexController.template = 'showcase/indexShowcase';
    IndexController.title = '橱窗宝贝';
    IndexController.navClass = 'showcaseItem';

    module.exports = IndexController;
});