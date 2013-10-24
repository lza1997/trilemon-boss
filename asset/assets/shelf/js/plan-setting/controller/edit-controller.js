define(function(require, exports, module) {

    var NewController = ['$scope', 'Restangular', 'PlanSettingForm', '$routeParams', function($scope, Restangular, PlanSettingForm, $routeParams) {

        Restangular.one('shelf/plan-settings', $routeParams.id).get().then(function(planSetting) {
            PlanSettingForm.initScope($scope, planSetting);
        });
    }];

    NewController.template = require('../template/new.html');
    NewController.title = "编辑计划";
    NewController.navClass = "planNew";

    module.exports = NewController;
});