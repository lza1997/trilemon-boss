/**
 * 中差评
 */
define(function(require, exports, module) {
    var moment = require('moment');
    var FORMAT = 'YYYY-MM-DD';

    var IndexController = ['$scope', 'BuyerRate', '$routeParams', '$location', '$modal', function($scope, BuyerRate, $routeParams, $location, $modal) {
        // 初始化
        $scope.init = function() {
            $routeParams.startDate = $routeParams.startDate || moment().add('days', -15).format(FORMAT);
            $routeParams.endDate = $routeParams.endDate || moment().format(FORMAT);

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
        $scope.auto = function(rate) {
            BuyerRate.auto({oids: [rate.oid]}, function() {
                BuyerRate.refreshCurrPage($scope.rates.currPage, getRates);
            });
        };

        // 批量自动评价
        $scope.batchAuto = function() {
            var checkedRates = _.filter($scope.rates, function(rate) {
                return rate.checked;
            });
            BuyerRate.auto({oids: _.pluck(checkedRates, 'oid')}, function() {
                BuyerRate.refreshCurrPage($scope.rates.currPage, getRates);
            });
        };

        $scope.openManual = function(rate) {
            var modal = $modal.open({
                templateUrl: 'rate/manualModal',
                controller: RateController,
                resolve: {
                    rate: function() {
                        return rate;
                    }
                }
            });
            modal.result.then(function() {
                BuyerRate.refreshCurrPage($scope.rates.currPage, getRates);
            });
        };


        // 搜索
        $scope.search = function() {
            if ($scope.searchForm.$valid) {
                getRates({
                    key: $scope.searchKey,
                    startDate: moment($scope.startDate).format(FORMAT),
                    endDate: moment($scope.endDate).format(FORMAT),
                    page: 1
                });
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
            return $scope.rates.$promise;
        }
    }];

    // 弹出层用于填写手工评价
    var RateController = ['$scope', '$modalInstance', 'rate', function($scope, $modalInstance, rate) {
        $scope.modal = $modalInstance;
        $scope.rate = rate;
        $scope.form = {};

        $scope.submitManual = function() {
            if ($scope.form.rate.$valid) {
                rate.comment = $scope.form.comment;
                rate.$manual(function() {
                    $modalInstance.close();
                });
            }
        };
    }];

    IndexController.title = '中差评 - 自动评价';
    IndexController.template = 'rate/indexRate';
    IndexController.navClass = 'rateBuyerRate';

    module.exports = IndexController;
});