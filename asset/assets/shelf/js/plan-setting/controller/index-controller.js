define(function(require, exports, module) {
    var modalTemplate = require('../template/modal.html');
    var filterTemplate = require('../template/filter.html');

    modalTemplate = modalTemplate.replace('<!-- content -->', filterTemplate);

    var IndexController = ['$scope', 'RestPageangular', 'URL', 'Flash', 'PLAN_STATUS', '$modal', 'Confirm',
        function($scope, RestPageangular, URL, Flash, PLAN_STATUS, $modal, Confirm) {

            // 初始化
            $scope.init = function() {
                $scope.planSettings = [];
                $scope.flashSuccess = Flash.success();
                $scope.planIndexUrl = true;
                $scope.PLAN_STATUS = PLAN_STATUS;
                getPlans();
            };

            // 暂停或继续
            $scope.pause = function(planSetting, flag) {
                var method = flag ? 'post' : 'remove';
                planSetting.one('pause')[method]().then(function(status) {
                    planSetting.status = parseInt(status, 10);
                });
            };

            // 删除计划
            $scope.delete = function(planSetting) {
                Confirm.open('确定要删除“' + planSetting.name + '”？').then(function() {
                    planSetting.remove().then(function() {
                        getPlans({page: $scope.planSettings.currPage}).then(function(data) {
                            if (data.length === 0) {
                                $scope.jumpPage($scope.planSettings.currPage - 1);
                            }
                        });
                    });
                });
            };

            // 筛选
            $scope.showFilterModal = function(planSetting) {
                ModalController.planSetting = planSetting;
                $modal.open({
                    template: modalTemplate,
                    controller: ModalController
                });
            };

            // 处理分页
            $scope.jumpPage = function(page) {
                getPlans({page: page});
            };

            // 获取 plan
            function getPlans(options) {
                options = options || {page: 1};
                var promise = RestPageangular.all(URL.PLAN_SETTING).getList(options);
                promise.then(function(data) {
                    $scope.planSettings = data;
                });
                return promise;
            }

            $scope.init();
        }];

    var ConfirmController = ['$scope', '$modalInstance', function($scope, $modalInstance) {
        $scope.dismiss = function() {
            $modalInstance.dismiss();
        };

        $scope.submit = function() {
            $modalInstance.close();
        };
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