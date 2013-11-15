/**
 * 创建计划
 */
define(function(require, exports, module) {

    var NewController = ['$scope', 'REST', 'PlanSetting', 'Flash', 'PlanSettingForm', function($scope, REST, PlanSetting, Flash, PlanSettingForm) {

        var planSetting = new PlanSetting({autoAddNewItems: true});
        PlanSettingForm.initScope($scope, planSetting);
    }];

    NewController.template = 'shelf/form';
    NewController.title = '创建计划';
    NewController.navClass = 'shelfNew';

    module.exports = NewController;
});