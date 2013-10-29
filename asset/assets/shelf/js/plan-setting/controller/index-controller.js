define(function(require, exports, module) {

    var IndexController = ['$scope', 'REST', 'Flash', 'PLAN_STATUS', 'Confirm', '$location', '$routeParams', function($scope, REST, Flash, PLAN_STATUS, Confirm, $location, $routeParams) {
        // 初始化
        $scope.init = function() {
            $scope.planSettings = [];
            $scope.flashSuccess = Flash.success();
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

        // 修改，会跳回当前页码的页面
        $scope.edit = function(planSetting) {
            $location.url('/plan-settings/ ' + planSetting.id + '/edit');
            Flash.tmp($scope.planSettings.currPage);
        };

        // 处理分页
        $scope.jumpPage = function(page) {
            $location.search('page', page);
            var promise = REST.PLAN_SETTING.getList({page: page || 1 });
            promise.then(function(data) {
                $scope.planSettings = data;
            });
            return promise;
        };

        $scope.init();
    }];

    IndexController.template = require('../template/index.html');
    IndexController.title = "计划列表";
    IndexController.navClass = "planIndex";

    module.exports = IndexController;
});