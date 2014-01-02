/**
 * 预览海报
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterActivity', 'PosterTemplate', '$routeParams', '$location', function($scope, PosterActivity, PosterTemplate, $routeParams, $location) {

        $scope.activity = PosterActivity.get({id: $routeParams.activityId, detail: true}, function(data) {
            $scope.items = _.map(data.activityItems, function(item) {
                _.extend(item, item.item);
                delete item.item;
                return item;
            });
            $scope.template = data.template;
        });

        // 保存
        $scope.save = function() {
            if (isValidate($scope.form)) {
                $scope.activity.$saveHTML(function() {
                    $location.url();
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
    }];

    Controller.title = '预览 - 宝贝海报';
    Controller.template = 'poster/preview';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});
