/**
 * 创建计划
 */
define(function(require, exports, module) {

    var NewController = ['$scope', 'REST', 'Flash', 'PlanSettingForm', function($scope, REST, Flash, PlanSettingForm) {

        var planSetting = REST.PLAN_SETTING.newOne();
        planSetting.autoAddNewItems = true;

        PlanSettingForm.initScope($scope, planSetting);
    }];

    NewController.template = 'shelf/form';
    NewController.title = '创建计划';
    NewController.navClass = 'shelfNew';

    module.exports = NewController;
});