define(function(require, exports, module) {
    var IndexController = ['$scope', 'Item', 'Plan', 'Flash', function($scope, Item, Plan, Flash) {

        // 初始化
        $scope.init = function() {
            $scope.plans = [];
            $scope.flashSuccess = Flash.success();
            $scope.planIndexUrl = true;
            getPlans();
        };

        // 处理分页
        $scope.jumpPage = function(page) {
            getPlans({page: page});
        };

        function getPlans(options) {
            options = options || {page: 1};
            Plan.getList(options).then(function(data) {
                $scope.plans = data;
            });
        }

        $scope.init();
    }];

    IndexController.template = require('../template/index.html');
    IndexController.title = "计划列表";
    IndexController.navClass = "planIndex";

    module.exports = IndexController;
});