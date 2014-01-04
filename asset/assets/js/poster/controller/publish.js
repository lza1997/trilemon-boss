/**
 * 投放设置
 */
define(function(require, exports, module) {
    var moment = require('moment');
    var FORMAT = 'YYYY-MM-DD';

    var Controller = ['$scope', 'PosterActivity', 'PosterItem', 'PosterSellerCat', '$routeParams', '$location', function($scope, PosterActivity, PosterItem, PosterSellerCat, $routeParams, $location) {

        $scope.init = function() {
            $scope.queryOptions = {onsale: 'true'};
            $scope.onsale = $scope.queryOptions.onsale;
            $scope.sellerCats = PosterSellerCat.query();
            $scope.activity = PosterActivity.get({
                id: $routeParams.id,
                publishItems: true
            }, function() {
                // 截止日期
                if ($scope.activity.publishEndTime) {
                    $scope.activity.publishEndTime = new Date($scope.activity.publishEndTime);
                }
                else {
                    $scope.activity.publishEndTime = moment().startOf('hour').toDate();
                }
                $scope.publishEndHour = $scope.activity.publishEndTime.getHours();
            });

            // 小时下拉框
            $scope.hours = _.map(_.range(24), function(i) {
                return {name: i + '时', value: i};
            });

            getItems();
        };

        $scope.init();

        // 参与投放
        $scope.setInclude = function(item, flag) {
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
            $scope.activity.publishEndTime.setHours($scope.publishEndHour);
            $scope.activity.$savePublish(function() {
                $location.url('/poster/activity');
            });
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