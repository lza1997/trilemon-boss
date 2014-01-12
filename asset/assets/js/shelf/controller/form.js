/**
 * 创建或修改计划
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PlanSetting', 'PlanSettingForm', '$rootScope', '$routeParams', function($scope, PlanSetting, PlanSettingForm, $rootScope, $routeParams) {

        if ($routeParams.id) {
            PlanSetting.get({id: $routeParams.id}, function(planSetting) {
                PlanSettingForm.initScope($scope, planSetting);
            });
            $rootScope.title = '修改计划';

        }
        else {
            var planSetting = new PlanSetting({autoAddNewItems: true});
            PlanSettingForm.initScope($scope, planSetting);
            $rootScope.title = '创建计划';
            $rootScope.navClass = 'shelfNew';
        }
    }];

    module.exports = Controller;
});