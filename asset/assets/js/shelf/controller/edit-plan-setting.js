/**
 * 挑选分类，其实是修改计划
 */
define(function(require, exports, module) {

    var EditController = ['$scope', 'REST', 'PlanSettingForm', '$routeParams', function($scope, REST, PlanSettingForm, $routeParams) {

        REST.PLAN_SETTING.get($routeParams.id).then(function(planSetting) {
            // 选中的分类 ID
            $scope.includeSellerCids = planSetting.includeSellerCids.split(',');

            PlanSettingForm.initScope($scope, planSetting);
        });
    }];

    EditController.template = 'shelf/form';
    EditController.title = "挑选分类";

    module.exports = EditController;
});