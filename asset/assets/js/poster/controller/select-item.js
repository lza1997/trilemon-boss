/**
 * 选择宝贝
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterItem', 'PosterTemplate', '$routeParams', '$location', 'Flash', function($scope, PosterItem, PosterTemplate, $routeParams, $location, Flash) {

        $scope.init = function() {
            if (!$routeParams.templateId) {
                $location.url('/poster/category');
                return;
            }
            $scope.searchKey = $routeParams.key;
            getItems();
            $scope.template = PosterTemplate.get({id: $routeParams.templateId});
        };

        $scope.init();

        // 加入
        $scope.setInclude = function(item, flag) {
            item.include = flag;
            $scope.selectedItems = _.where($scope.items, {include: true});
        };

        // 搜索
        $scope.search = function() {
            getItems({key: $scope.searchKey, page: 1});
        };

        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 获取宝贝列表，可以传入分类、页码等
        function getItems(options) {
            // 合并 URL 上的参数，并将新参数再次写入 URL
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);

            $scope.items = PosterItem.query(_.omit(options, 'templateId'), function(data) {
                // 选中的回填
                var ids = _.pluck($scope.selectedItems, 'numIid');
                _.each(data, function(item) {
                    if (_.contains(ids, item.numIid)) {
                        item.include = true;
                    }
                });

            });
            return $scope.items.$promise;
        }
    }];

    Controller.title = '选择宝贝 - 宝贝海报';
    Controller.template = 'poster/selectItem';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});