/**
 * 用于弹出层显示折线图
 */
define(function(require, exports, module) {
    var ChartController = ['$scope', '$modalInstance', 'PlanSetting', function($scope, $modalInstance, PlanSetting) {
        $scope.modal = $modalInstance;
        PlanSetting.chart(function(data) {
            $scope.data = {
                title: {
                    text: ''
                },
                xAxis: {
                    categories: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                },
                yAxis: {
                    title: {
                        text: ''
                    },
                    min: 0
                },
                legend: {
                    enabled: false
                },
                series: [
                    {
                        name: "上架宝贝数量",
                        data: _.pluck(data, 'value')
                    }
                ]
            };
        });
    }];

    module.exports = ChartController;
});