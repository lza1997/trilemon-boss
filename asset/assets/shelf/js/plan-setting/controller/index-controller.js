define(function(require, exports, module) {
    var modalTemplate = require('../template/modal.html');
    var filterTemplate = require('../template/filter.html');

    modalTemplate = modalTemplate.replace('<!-- content -->', filterTemplate);


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

        $scope.delete = function(planSetting) {
            if (confirm('确定删除“' + planSetting.name + '”？')) {
                planSetting.remove().then(function() {
                    getPlans({page: $scope.planSettings.currPage});
                });
            }
        };

        $scope.showFilterModal = function(planSetting) {
            ModalController.planSetting = planSetting;
            $modal.open({
                template: modalTemplate,
                controller: ModalController
            });
        };

        // 获取 plan
        function getPlans(options) {
            options = options || {page: 1};
            PlanSetting.getList(options).then(function(data) {
                $scope.planSettings = data;
            });
        }

        $scope.init();
    }];

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