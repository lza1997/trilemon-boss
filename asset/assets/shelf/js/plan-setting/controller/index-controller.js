define(function(require, exports, module) {
    var modalTemplate = require('../template/modal.html');

    var IndexController = ['$scope', 'Item', 'PlanSetting', 'Flash', '$modal', function($scope, Item, PlanSetting, Flash, $modal) {

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

        $scope.showFilterModal = function(planSetting) {
            ModalController.planSetting = planSetting;
            $modal.open({
                template: modalTemplate,
                controller: ModalController
            });
        };

        function getPlans(options) {
            options = options || {page: 1};
            PlanSetting.getList(options).then(function(data) {
                $scope.planSettings = data;
            });
        }

        $scope.init();
    }];

    var FilterController = require('./filter-controller');

    var ModalController = ['$scope', 'ItemFilter', '$modalInstance', function($scope, ItemFilter, $modalInstance) {
        ItemFilter.initScope($scope, ModalController.planSetting);

        $scope.dismiss = function() {
            $modalInstance.dismiss();
        };

        $scope.submit = function() {
            $scope.save().then(function() {
                $modalInstance.close();
            });
        };
    }];

    IndexController.template = require('../template/index.html');
    IndexController.title = "计划列表";
    IndexController.navClass = "planIndex";

    module.exports = IndexController;
});