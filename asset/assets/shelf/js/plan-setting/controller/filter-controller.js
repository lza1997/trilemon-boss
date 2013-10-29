define(function(require, exports, module) {

    var FilterController = ['$scope', 'REST', '$routeParams', function($scope, REST, $routeParams) {

        $scope.items = [];
        $scope.lastSearchKey = '';  // 上一次搜索的关键词
        getItems($scope); // 初始化时取第一页数据

        // 搜索
        $scope.search = function() {
            getItems($scope, {key: $scope.searchKey});
            $scope.lastSearchKey = $scope.searchKey;
        };

        // 处理分页
        $scope.jumpPage = function(page) {
            getItems($scope, {page: page, key: $scope.lastSearchKey});
        };

        // 排除宝贝
        $scope.setExclude = function(item, flag) {
            item.exclude = flag;
            var method = flag ? 'post' : 'remove';
            var planSetting = REST.PLAN_SETTING.one($routeParams.id);
            planSetting.one('exclude-item', item.numIid)[method]();
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems($scope, options) {
            options = options || {};
            options.pid = $routeParams.id;

            REST.ITEM.getList(options).then(function(data) {
                $scope.items = data;
            });
        }
    }];

    FilterController.template = require('../template/filter.html');
    FilterController.title = "筛选宝贝";

    module.exports = FilterController;
});