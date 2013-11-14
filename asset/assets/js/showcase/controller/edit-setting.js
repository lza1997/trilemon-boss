/**
 * 设置规则
 */
define(function(require, exports, module) {
    var EditRuleController = ['$scope', 'Setting', 'REST', 'Sellercat', 'SHOWCASE_SETTING_STATUS', '$location', '$q', function($scope, Setting, REST, Sellercat, SHOWCASE_SETTING_STATUS, $location, $q) {

        $scope.setting = Setting.get();
        $scope.sellerCats = Sellercat.query();

        $q.all([$scope.setting.$promise, $scope.sellerCats.$promise]).then(function() {
            // 显示页面时回填
            Sellercat.setCheckedByIds($scope.sellerCats, $scope.setting.includeSellerCids);

            // 将选中分类的 id 写入 setting 对象
            $scope.$watch('sellerCats', function(value) {
                var selectedCids = _.chain(value).where({checked: true}).pluck('cid').value();
                $scope.setting.includeSellerCids = selectedCids.join(',');
            }, true);
        });

        // 设置规则开启
        $scope.setPaused = function(flag) {
            var method = flag ? 'pause' : 'resume';
            Setting[method](function(data) {
                $scope.setting = data;
            });
        };

        // 保存
        $scope.save = function() {
            if (isValidate()) {
                $scope.setting.$save().then(function() {
                    $location.path('/showcase/showcase-item');
                });
            }
        };

        // 校验表单
        function isValidate() {
            for (var field in $scope.form) {
                if (field[0] !== '$' && $scope.form[field].$pristine) {
                    $scope.form[field].$setViewValue($scope.form[field].$modelValue);
                }
            }
            return $scope.form.$valid;
        }

        // 包装一下 setting 对象
        function wrapSetting(setting) {
            $scope.isPaused = (setting.status === SHOWCASE_SETTING_STATUS.PAUSED);
            setting.includeSellerCids = setting.includeSellerCids || '';
            return setting;
        }
    }];

    EditRuleController.template = 'showcase/editSetting';
    EditRuleController.title = '橱窗推荐规则';
    EditRuleController.navClass = 'showcaseEdit';

    module.exports = EditRuleController;
});