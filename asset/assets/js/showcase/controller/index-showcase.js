/**
 * 橱窗宝贝
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'REST', function($scope, REST) {
        $scope.items = [];
        $scope.lastSearchKey = '';  // 上一次搜索的关键词
        getItems($scope); // 初始化时取第一页数据

        REST.SHOWCASE_SETTING.get().then(function(data) {
            // TODO
        });

        // 搜索
        $scope.search = function() {
            getItems($scope, {key: $scope.searchKey});
            $scope.lastSearchKey = $scope.searchKey;
        };

        $scope.jumpPage = function(page) {
            getItems($scope, {page: page, key: $scope.lastSearchKey});
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems($scope, options) {
            options = options || {};

            REST.SHOWCASE_ITEM.getList(options).then(function(data) {
                $scope.items = data;
            });
        }
    }];

    IndexController.template = 'showcase/indexShowcase';
    IndexController.title = '橱窗宝贝';
    IndexController.navClass = 'showcaseItem';

    module.exports = IndexController;
});