/**
 * 筛选宝贝
 */
define(function(require, exports, module) {

    var FilterController = ['$scope', 'PlanItem', '$routeParams', '$location', function($scope, PlanItem, $routeParams, $location) {

        $scope.searchKey = $routeParams.key;  // 上一次搜索的关键词
        getItems(); // 初始化时取第一页数据

        // 搜索
        $scope.search = function() {
            getItems({key: $scope.searchKey, page: 1});
        };

        // 处理分页
        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 排除宝贝
        $scope.setExclude = function(item, flag) {
            var method = flag ? '$exclude' : '$include';
            item[method]({id: $routeParams.id});
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems(options) {
            options = _.defaults(options || {}, $routeParams);
            $location.search(_.omit(options, 'id'));

            PlanItem.query(options, function(data) {
                $scope.items = data;
            });
        }
    }];

    FilterController.template = 'shelf/filter';
    FilterController.title = "筛选宝贝";

    module.exports = FilterController;
});