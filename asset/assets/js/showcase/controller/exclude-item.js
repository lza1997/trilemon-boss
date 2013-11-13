/**
 * 排除宝贝
 */
define(function(require, exports, module) {
    var ExcludeItemController = ['$scope', 'REST', 'SHOWCASE_ITEM_STATUS', function($scope, REST, SHOWCASE_ITEM_STATUS) {
        $scope.items = [];
        $scope.lastSearchKey = '';  // 上一次搜索的关键词
        $scope.categories = [
            {name: '出售中的宝贝', value: 'onsale'},
            {name: '仓库中的宝贝', value: 'inventory'}
        ];
        $scope.category = 'onsale';

        // 切换下拉框即请求数据，初始化时也会执行一次
        $scope.$watch('category', function() {
            getItems($scope);
        });

        // 搜索
        $scope.search = function() {
            getItems($scope, {key: $scope.searchKey});
            $scope.lastSearchKey = $scope.searchKey;
        };

        // 排除或取消排除
        $scope.setExclude = function(item, flag) {
            item.exclude = flag;
            var method = flag ? 'post' : 'remove';
            REST.SHOWCASE_SETTING_ITEM.one(item.numIid).one('exclude')[method]();
        };

        $scope.jumpPage = function(page) {
            getItems($scope, {
                page: page,
                key: $scope.lastSearchKey
            });
        };

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems($scope, options) {
            options = _.extend(options || {}, {category: $scope.category});

            REST.SHOWCASE_SETTING_ITEM.getList(options).then(function(data) {
                // 服务器数据再组装
                data = _.map(data, function(item) {
                    item.exclude = item.status === SHOWCASE_ITEM_STATUS.EXCLUDE;
                    return _.extend(item.item, _.omit(item, 'item'));
                });
                $scope.items = data;
            });
        }
    }];

    ExcludeItemController.template = 'showcase/excludeItem';
    ExcludeItemController.title = '排除宝贝';

    module.exports = ExcludeItemController;
});