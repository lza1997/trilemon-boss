define(function(require, exports, module) {
    var modalTemplate = require('../template/modal.html');
    var filterTemplate = require('../template/filter.html');

    modalTemplate = modalTemplate.replace('<!-- content -->', filterTemplate);

    var IndexController = ['$scope', 'RestPageangular', 'URL', 'Flash', 'PLAN_STATUS', '$modal', 'Confirm', '$location', '$routeParams',
        function($scope, RestPageangular, URL, Flash, PLAN_STATUS, $modal, Confirm, $location, $routeParams) {

            // 初始化
            $scope.init = function() {
                $scope.planSettings = [];
                $scope.flashSuccess = Flash.success();
                $scope.planIndexUrl = true;
                $scope.PLAN_STATUS = PLAN_STATUS;
                $scope.jumpPage($routeParams.page);
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
                        $scope.jumpPage($scope.planSettings.currPage).then(function(data) {
                            if (data.length === 0) {
                                $scope.jumpPage($scope.planSettings.currPage - 1);
                            }
                        });
                    });
                });
            };

            $scope.edit = function(planSetting) {
                $location.url('/plan-settings/ ' + planSetting.id + '/edit');
                Flash.tmp($scope.planSettings.currPage);
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
                $location.search('page', page);
                var promise = RestPageangular.all(URL.PLAN_SETTING).getList({page: page || 1 });
                promise.then(function(data) {
                    $scope.planSettings = data;
                });
                return promise;
            };

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