/**
 * 预览海报
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterActivity', 'PosterTemplate', '$modal', '$routeParams', '$location', function($scope, PosterActivity, PosterTemplate, $modal, $routeParams, $location) {

        $scope.activity = PosterActivity.get({
            id: $routeParams.id,
            template: true,
            activityItems: true
        }, function(data) {
            $scope.items = data.activityItems;
            $scope.template = data.template;
        });

        // 保存
        $scope.save = function() {
            if (isValidate($scope.form)) {
                $scope.activity.$saveHTML(function() {
                    $location.url('/poster/activity/' + $routeParams.id + '/publish');
                });
            }
        };

        // 校验表单
        function isValidate(form) {
            for (var field in form) {
                if (field[0] !== '$' && form[field].$pristine) {
                    form[field].$setViewValue(form[field].$modelValue);
                }
            }
            return form.$valid;
        }

        // 显示代码
        $scope.showCode = function(activity) {
            var modal = $modal.open({
                templateUrl: 'poster/codeModal',
                controller: ['$scope', '$modalInstance', function($scope, $modalInstance) {
                    $scope.activity = activity;
                    $scope.modal = $modalInstance;
                }]
            });
        };
    }];

    Controller.title = '预览 - 宝贝海报';
    Controller.template = 'poster/preview';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});
