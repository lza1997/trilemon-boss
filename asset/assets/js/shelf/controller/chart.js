/**
 * 用于弹出层显示折线图
 */
define(function(require, exports, module) {
    var ChartController = ['$scope', '$modalInstance', 'REST', function($scope, $modalInstance, REST) {
        $scope.modal = $modalInstance;
        REST.PLAN_SETTING.one('chart').get().then(function(data) {
            $scope.data = {
                title: {
                    text: '我也不知道叫啥'
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
                tooltip: {

                },
                legend: {
                    enabled: false
                },
                series: [
                    {
                        name: "上架宝贝数量",
                        data: data
                    }
                ]
            };
        });
    }];

    module.exports = ChartController;
});