/**
 * 投放设置
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterActivity', 'PosterItem', 'PosterSellerCat', '$routeParams', '$location', function($scope, PosterActivity, PosterItem, PosterSellerCat, $routeParams, $location) {

        $scope.init = function() {
            $scope.queryOptions = {onsale: 'true'};
            $scope.onsale = $scope.queryOptions.onsale;
            $scope.sellerCats = PosterSellerCat.query();
            $scope.activity = PosterActivity.get({id: $routeParams.id});

            // 截止日期
            $scope.hours = _.map(_.range(25), function(i) {
                return {name: i + '时', value: i};
            });
            $scope.endDate = new Date();
            $scope.endHour = new Date().getHours();
            getItems();
        };

        $scope.init();

        // 参与投放
        $scope.setInclude = function(item, flag) {
            $scope.activity.publishItems = $scope.activity.publishItems || [];

            item.include = flag;
            if (flag) {
                $scope.activity.publishItems.push(item);
            }
            else {
                $scope.activity.publishItems = _.without($scope.activity.publishItems, item);
            }
        };

        // 保存
        $scope.save = function() {

        };

        // 切换在售与库存
        $scope.changeOnsale = function() {
            $scope.searchKey = '';
            $scope.category = '';
            getItems({onsale: $scope.onsale, category: '', key: '', page: 1});
        };

        // 切换分类
        $scope.changeCategory = function() {
            $scope.searchKey = '';
            getItems({category: $scope.category, key: '', page: 1});
        };

        // 搜索
        $scope.search = function() {
            getItems({key: $scope.searchKey, page: 1});
        };

        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 获取宝贝列表，可以传入分类、页码等
        // 此处不保留 URL 参数
        function getItems(options) {
            $scope.queryOptions = _.defaults(options || {}, $scope.queryOptions);

            var items = PosterItem.query($scope.queryOptions, function(data) {
                // 选中的回填
                var ids = _.pluck($scope.activity.publishItems, 'numIid');
                _.each(data, function(item) {
                    item.include = _.contains(ids, item.numIid);
                });
                $scope.items = data;
            });
            return items.$promise;
        }
    }];

    Controller.title = '设置海报投放 - 宝贝海报';
    Controller.template = 'poster/publish';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});