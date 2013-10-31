define(function(require, exports, module) {

    var NewController = ['$scope', 'REST', 'Flash', 'PlanSettingForm', function($scope, REST, Flash, PlanSettingForm) {

        var planSetting = REST.PLAN_SETTING.newOne();
        planSetting.autoAddNewItems = true;

        PlanSettingForm.initScope($scope, planSetting);
    }];

    NewController.template = 'planSetting/form';
    NewController.title = "创建计划";
    NewController.navClass = "planNew";

    module.exports = NewController;
});