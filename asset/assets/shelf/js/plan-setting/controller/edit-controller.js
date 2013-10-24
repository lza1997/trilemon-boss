define(function(require, exports, module) {

    var NewController = ['$scope', 'Restangular', 'URL', 'PlanSettingForm', '$routeParams', function($scope, Restangular, URL, PlanSettingForm, $routeParams) {
        Restangular.one(URL.PLAN_SETTING, $routeParams.id).get().then(function(planSetting) {
            // 选中的分类 ID
            $scope.includeCids = $scope.planSetting.includeCids.split(',');

            PlanSettingForm.initScope($scope, planSetting);
        });
    }];

    NewController.template = require('../template/form.html');
    NewController.title = "编辑计划";
    NewController.navClass = "";

    module.exports = NewController;
});