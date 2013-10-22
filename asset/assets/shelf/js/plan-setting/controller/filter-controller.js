define(function(require, exports, module) {
    var FilterController = ['$scope', 'PlanSetting', '$location', 'Flash', 'ItemFilter', function($scope, PlanSetting, $location, Flash, ItemFilter) {
        //没有临时的 Plan 数据时跳回页面
        if (!PlanSetting.tmpData) {
            $location.url('/plan/new');
        }
        else {
            ItemFilter.initScope($scope, PlanSetting.tmpData);

            $scope.submit = function() {
                $scope.save().then(function() {
                    Flash.success('计划 ' + PlanSetting.tmpData.name + ' 创建成功！');
                    $location.url('/plan');
                });
            };
        }
    }];

    FilterController.template = require('../template/filter.html');
    FilterController.title = "筛选宝贝";
    FilterController.navClass = "planNew";

    module.exports = FilterController;
});