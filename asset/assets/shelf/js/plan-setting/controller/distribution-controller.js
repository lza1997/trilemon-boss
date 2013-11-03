/**
 * 手动设置上架时间
 */
define(function(require, exports, module) {

    var DistributionController = ['$scope', 'REST', '$modal', '$routeParams', '$location', function($scope, REST, $modal, $routeParams, $location) {
        $scope.weeks = _.map('周一 周二 周三 周四 周五 周六 周日'.split(' '), function(v, index) {
            return {name: v, value: index + 1 + '', checked: false};
        });

        REST.PLAN_SETTING.one($routeParams.id).one('distribution').get().then(function(data) {
            // 格式为 {1: {1:true, 2:false, ... , 23:true}, ...}
            $scope.distribution = data;

            // 回填周几是否被选中
            _.each(_.pick(data, _.range(1, 8)), function(v, k) {
                var week = _.findWhere($scope.weeks, {value: k});
                week.checked = _.any(v);
            });
        });

        $scope.checkWeek = function(week) {
            if (!week.checked) {
                $scope.distribution[week.value] = {};
            }
        };

        $scope.showModal = function(week) {
            $modal.open({
                templateUrl: 'planSetting/distributionModal',
                controller: ModalController,
                resolve: {
                    distribution: function() {
                        return $scope.distribution[week.value];
                    }
                }
            });
        };

        $scope.save = function() {
            $scope.distribution.put().then(function() {
                $location.url('/plan-setting');
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

    DistributionController.template = 'planSetting/distribution';
    DistributionController.title = "设置上架时间";

    module.exports = DistributionController;
});