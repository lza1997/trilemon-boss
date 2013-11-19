/**
 * 橱窗宝贝
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'ShowcaseItem', 'ShowcaseSetting', '$location', '$routeParams', function($scope, ShowcaseItem, ShowcaseSetting, $location, $routeParams) {

        $scope.searchKey = $routeParams.key;
        getItems(); // 初始化时取第一页数据
        $scope.setting = ShowcaseSetting.get();

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
            $scope.items = ShowcaseItem.query(options);
        }
    }];

    IndexController.template = 'showcase/indexShowcase';
    IndexController.title = '橱窗宝贝';
    IndexController.navClass = 'showcaseItem';

    module.exports = IndexController;
});