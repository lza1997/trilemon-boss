/**
 * 计划列表
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'REST', 'PlanSetting', 'Flash', 'PLAN_STATUS', 'Confirm', '$location', '$routeParams', '$modal', function($scope, REST, PlanSetting, Flash, PLAN_STATUS, Confirm, $location, $routeParams, $modal) {
        // 初始化
        $scope.init = function() {
            $scope.flashSuccess = Flash.success();
            $scope.PLAN_STATUS = PLAN_STATUS;
            $scope.jumpPage($routeParams.page);
        };

        // 暂停或继续
        $scope.pause = function(planSetting, flag) {
            var method = flag ? '$pause' : '$resume';
            planSetting[method](function() {

            });
            //            var method = flag ? 'post' : 'remove';
            //            planSetting.one('pause')[method]().then(function(status) {
            //                planSetting.status = parseInt(status, 10);
            //            });
        };

        // 删除计划
        $scope.remove = function(planSetting) {
            Confirm.open('确定要删除“' + planSetting.name + '”？').then(function() {
                planSetting.$remove(function() {
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
            $scope.planSettings = PlanSetting.query({page: page || 1});
            return $scope.planSettings.$promise;
        };

        // 统计图表
        $scope.showChart = function() {
            var modal = $modal.open({
                templateUrl: 'shelf/chart',
                controller: require('./chart')
            });
        };

        $scope.init();
    }];

    IndexController.template = 'shelf/index';
    IndexController.title = '计划列表';
    IndexController.navClass = 'shelfIndex';

    module.exports = IndexController;
});