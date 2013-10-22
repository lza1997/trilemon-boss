define(function(require, exports, module) {
    var IndexController = ['$scope', 'Item', 'PlanSetting', 'Flash', function($scope, Item, PlanSetting, Flash) {

        // 初始化
        $scope.init = function() {
            $scope.planSettings = [];
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
            PlanSetting.getList(options).then(function(data) {
                $scope.planSettings = data;
            });
        }

        $scope.init();
    }];

    IndexController.template = require('../template/index.html');
    IndexController.title = "计划列表";
    IndexController.navClass = "planIndex";

    module.exports = IndexController;
});