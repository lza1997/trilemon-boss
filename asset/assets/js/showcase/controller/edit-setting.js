/**
 * 设置规则
 */
define(function(require, exports, module) {
    var EditRuleController = ['$scope', 'REST', 'SellerCat', 'SHOWCASE_SETTING_STATUS', '$location', function($scope, REST, SellerCat, SHOWCASE_SETTING_STATUS, $location) {
        REST.SHOWCASE_SETTING.get().then(function(data) {
            $scope.setting = wrapSetting(data);

            // 获取卖家的宝贝分类
            SellerCat.setREST(REST.SHOWCASE_SELLERCAT);
            SellerCat.fetch({selectedCids: data.includeSellerCids.split(',')}).then(function(data) {
                $scope.sellerCats = data;
            });

            // 将选中分类的 id 写入 setting 对象
            $scope.$watch('sellerCats', function(value) {
                var selectedCids = _.chain(value).where({selected: true}).pluck('cid').value();
                $scope.setting.includeSellerCids = selectedCids.join(',');
            }, true);
        });

        // 设置规则开启
        $scope.setPaused = function(flag) {
            var method = flag ? 'post' : 'remove';
            REST.SHOWCASE_SETTING.one('pause')[method]().then(function(data) {
                $scope.setting = data;
                $scope.setting.isPaused = data.status === SHOWCASE_SETTING_STATUS.PAUSED;
            });
        };

        // 分类的父子联动选择
        $scope.check = function(cat) {
            SellerCat.checkSellerCat(cat, $scope.sellerCats);
        };

        // 展开或折叠父分类
        $scope.toggleSellerCat = SellerCat.toggleSellerCat;

        // 保存
        $scope.save = function() {
            if (isValidate()) {
                $scope.setting.put().then(function() {
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
            setting.isPaused = (setting.status === SHOWCASE_SETTING_STATUS.PAUSED);
            setting.includeSellerCids = setting.includeSellerCids || '';
            return setting;
        }
    }];

    EditRuleController.template = 'showcase/editSetting';
    EditRuleController.title = '橱窗推荐规则';
    EditRuleController.navClass = 'showcaseEdit';

    module.exports = EditRuleController;
});