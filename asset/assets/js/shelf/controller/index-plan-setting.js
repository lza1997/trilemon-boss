/**
 * 计划列表
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'PlanSetting', 'Flash', 'Confirm', '$location', '$routeParams', '$modal', 'RelativeUrlFactory', function($scope, PlanSetting, Flash, Confirm, $location, $routeParams, $modal, RelativeUrlFactory) {
        $scope.relativeUrl = RelativeUrlFactory.create(module);

        // 初始化
        $scope.init = function() {
            $scope.flashSuccess = Flash.success();
            $scope.jumpPage($routeParams.page);
        };

        // 暂停或继续
        $scope.pause = function(planSetting, flag) {
            var method = flag ? '$pause' : '$resume';
            planSetting[method]();
        };

        // 删除计划
        $scope.remove = function(planSetting) {
            Confirm.open('确定要删除“' + planSetting.name + '”？').then(function() {
                PlanSetting.removeFromList(planSetting, $scope.planSettings, function(options) {
                    return $scope.jumpPage(options.page);
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
            var items = PlanSetting.query({page: page || 1}, function(data){
                $scope.planSettings = data;
            });
            return items.$promise;
        };

        // 统计图表
        $scope.showChart = function() {
            var modal = $modal.open({
                templateUrl: $scope.relativeUrl('./chart.html'),
                controller: require('./chart')
            });
        };

        $scope.init();
    }];

    IndexController.title = '计划列表 - 上下架';
    IndexController.navClass = 'shelfIndex';

    module.exports = IndexController;
});