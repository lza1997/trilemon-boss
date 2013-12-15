/**
 * 中差评
 */
define(function(require, exports, module) {
    var moment = require('moment');

    var IndexController = ['$scope', 'BuyerRate', '$routeParams', '$location', function($scope, BuyerRate, $routeParams, $location) {
        // 初始化
        $scope.init = function() {
            $routeParams.startDate = $routeParams.startDate || moment().add('days', -15).format('YYYY-MM-DD');
            $routeParams.endDate = $routeParams.endDate || moment().format('YYYY-MM-DD');

            $scope.searchKey = $routeParams.key;
            $scope.startDate = $routeParams.startDate;
            $scope.endDate = $routeParams.endDate;
            getRates();
        };

        $scope.init();

        // 全选与单独选择的联动
        $scope.toggleCheckedAll = function() {
            _.each($scope.rates, function(rate) {
                rate.checked = $scope.allChecked;
            });
        };
        $scope.toggleChecked = function() {
            $scope.allChecked = _.all($scope.rates, function(rate) {
                return rate.checked;
            });
        };

        // 自动评价
        $scope.auto = function(rate){
            BuyerRate.auto({oids: [rate.oid]});
        };

        $scope.search = function() {
            if ($scope.searchForm.$valid) {
                getRates({key: $scope.searchKey, page: 1});
            }
        };

        // 分页
        $scope.jumpPage = function(page) {
            getRates({page: page});
        };

        // 获取评论列表，可以传入关键词、页码等
        function getRates(options) {
            options = _.defaults(options || {}, $routeParams);

            // remove falsy prop
            _.each(_.keys(options), function(k) {
                if (!options[k]) {
                    delete options[k];
                }
            });
            $location.search(options);

            $scope.rates = BuyerRate.query(options);
            $scope.allChecked = false;
        }
    }];

    IndexController.title = '中差评 - 自动评价';
    IndexController.template = 'rate/indexRate';
    IndexController.navClass = 'rateBuyerRate';

    module.exports = IndexController;
});