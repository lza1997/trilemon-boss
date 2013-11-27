/**
 * 手动设置上架时间
 */
define(function(require, exports, module) {

    var DistributionController = ['$scope', 'DistributionFactory', '$modal', '$location', function($scope, DistributionFactory, $modal, $location) {
        var Distribution = DistributionFactory.create('/inventory/setting/distribution');

        $scope.distribution = Distribution.query();

        $scope.showModal = function(day) {
            $modal.open({
                templateUrl: 'inventory/distributionModal',
                controller: ModalController,
                resolve: {
                    distribution: function() {
                        return day.hours;
                    }
                }
            });
        };

        $scope.save = function() {
            Distribution.save({distribution: $scope.distribution}, function() {
                $location.url('/inventory/show-setting');
            });
        };

    }];

    // 选择时间的弹出层
    var ModalController = ['$scope', '$modalInstance', 'distribution', function($scope, $modalInstance, distribution) {
        $scope.modal = $modalInstance;
        $scope.distribution = distribution;
        $scope.tabs = [
            {name: '上午', value: 6, active: true},
            {name: '下午', value: 12},
            {name: '晚上', value: 18},
            {name: '凌晨', value: 0}
        ];

        $scope.selectTab = function(tab) {
            $scope.hours = _.range(tab.value, tab.value + 6);
            _.each($scope.tabs, function(t) {
                t.active = false;
            });
            tab.active = true;
        };

        $scope.selectTab(_.first($scope.tabs));
    }];

    DistributionController.template = 'inventory/distribution';
    DistributionController.title = "设置上架时间";

    module.exports = DistributionController;
});