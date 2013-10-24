define(function(require, exports, module) {
    var FilterController = ['$scope', '$location', 'Flash', 'ItemFilter', function($scope, $location, Flash, ItemFilter) {
        //没有临时的 Plan 数据时跳回页面
        var tmpPlanSetting = Flash.tmp();
        if (!tmpPlanSetting) {
            $location.url('/plan-setting/new');
        }
        else {
            ItemFilter.initScope($scope, tmpPlanSetting);

            $scope.submit = function() {
                $scope.save().then(function() {
                    Flash.success('计划 ' + tmpPlanSetting.name + ' 创建成功！');
                    $location.url('/plan-setting');
                });
            };
        }
    }];

    FilterController.template = require('../template/filter.html');
    FilterController.title = "筛选宝贝";
    FilterController.navClass = "planNew";

    module.exports = FilterController;
});