define(function(require, exports, module) {

    var NewController = ['$scope', 'Restangular', 'Flash', 'PlanSettingForm', function($scope, Restangular, Flash, PlanSettingForm) {

        var planSetting = Restangular.one('shelf/plan-settings');
        planSetting.autoAddNewItems = true;

        PlanSettingForm.initScope($scope, planSetting);
    }];

    NewController.template = require('../template/form.html');
    NewController.title = "创建计划";
    NewController.navClass = "planNew";

    module.exports = NewController;
});