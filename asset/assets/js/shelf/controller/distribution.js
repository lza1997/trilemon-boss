/**
 * 手动设置上架时间
 */
define(function(require, exports, module) {

    var DistributionController = ['$scope', 'DistributionFactory', '$modal', '$routeParams', '$location', function($scope, DistributionFactory, $modal, $routeParams, $location) {
        var Distribution = DistributionFactory.create('/shelf/plan-settings/:id/distribution');

        // 格式为 {1: {1:true, 2:false, ... , 23:true}, ...}
        $scope.distribution = Distribution.query({id: $routeParams.id});

        $scope.showModal = function(day) {
            $modal.open({
                templateUrl: 'shelf/distributionModal',
                controller: ModalController,
                resolve: {
                    distribution: function() {
                        return day.hours;
                    }
                }
            });
        };

        $scope.save = function() {
            Distribution.save({
                id: $routeParams.id,
                distribution: $scope.distribution
            }, function() {
                $location.url('/shelf/plan-setting');
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

    DistributionController.template = 'shelf/distribution';
    DistributionController.title = "设置上架时间";

    module.exports = DistributionController;
});