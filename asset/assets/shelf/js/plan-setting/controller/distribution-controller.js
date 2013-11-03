/**
 * 手动设置上架时间
 */
define(function(require, exports, module) {

    var DistributionController = ['$scope', 'REST', '$modal', function($scope, REST, $modal) {
        $scope.weeks = _.map('周一 周二 周三 周四 周五 周六 周日'.split(' '), function(v, index) {
            return {name: v, value: index + 1 + '', checked: false};
        });

        $scope.distribution = {
            1: {
                1: true,
                2: true,
                3: true,
                4: true,
                5: true,
                6: true,
                7: true,
                9: true,
                10: true,
                11: true,
                12: true,
                13: true,
                14: true,
                15: true,
                16: true,
                17: true
            },
            2: {
                10: true,
                11: false
            },
            3: {},
            4: {},
            5: {},
            6: {},
            7: {}
        };

        _.each($scope.distribution, function(v, k){
            var week = _.findWhere($scope.weeks, {value: k});
            week.checked = _.any(v);
        });

        $scope.showModal = function(week) {
            $modal.open({
                templateUrl: 'planSetting/distributionModal',
                controller: function($scope, $modalInstance, week, distribution) {
                    $scope.modal = $modalInstance;
                    $scope.week = week.value;
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
                },
                resolve: {
                    week: function() {
                        return week;
                    },

                    distribution: function(){
                        return $scope.distribution;
                    }
                }
            });
        };

    }];

    DistributionController.template = 'planSetting/distribution';
    DistributionController.title = "设置上架时间";

    module.exports = DistributionController;
});