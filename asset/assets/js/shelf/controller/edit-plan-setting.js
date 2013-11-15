/**
 * 挑选分类，其实是修改计划
 */
define(function(require, exports, module) {

    var EditController = ['$scope', 'PlanSetting', 'PlanSettingForm', '$routeParams', function($scope, PlanSetting, PlanSettingForm, $routeParams) {

        PlanSetting.get({id: $routeParams.id}, function(planSetting) {
            PlanSettingForm.initScope($scope, planSetting);
        });
    }];

    EditController.template = 'shelf/form';
    EditController.title = "挑选分类";

    module.exports = EditController;
});