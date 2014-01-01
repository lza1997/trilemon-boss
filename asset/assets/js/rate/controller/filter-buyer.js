/**
 * 买家过滤
 */
define(function(require, exports, module) {
    var FilterController = ['$scope', 'Blacklist', 'RateSetting', '$timeout', function($scope, Blacklist, RateSetting, $timeout) {
        $scope.tab = 'filter';

        $scope.setting = RateSetting.get();

        watchRadio('enableCreditFilter', 'creditFilterMin');
        watchRadio('enableGoodRateFilter', 'goodRateFilter');
        watchRadio('enableRegisterDayFilter', 'registerDayFilter');
        watchRadio('enableBadRateFilter', 'badRateFilter');

        $scope.saveSetting = function() {
            if (isValidate()) {
                $scope.setting.$update(function() {
                    $scope.saveSuccess = true;
                    $timeout(function() {
                        $scope.saveSuccess = false;
                    }, 3000);
                });
            }
        };

        // 校验表单
        function isValidate() {
            for (var field in $scope.settingForm) {
                if (field[0] !== '$' && $scope.settingForm[field].$pristine) {
                    $scope.settingForm[field].$setViewValue($scope.settingForm[field].$modelValue);
                }
            }
            return $scope.settingForm.$valid;
        }

        // 监听单选框，如果切换时原来的输入框有错误，则修复，以免影响提交
        function watchRadio(radio, input) {
            $scope.$watch('setting.' + radio, function(value) {
                if (!value && $scope.settingForm[input].$invalid) {
                    $scope.setting[input] = 1;
                }
            });
        }

        $scope.blacklist = Blacklist.query();
        $scope.newBlacklist = new Blacklist();

        // 添加黑名单
        $scope.addBlacklist = function() {
            if ($scope.addForm.$valid) {
                $scope.newBlacklist.$save(function() {
                    $scope.blacklist.push(angular.copy($scope.newBlacklist));
                    $scope.newBlacklist = new Blacklist();
                    $scope.addForm.$setPristine();
                });
            }
        };

        // 删除黑名单
        $scope.removeBlacklist = function(blacklist) {
            blacklist.$remove({nick: blacklist.buyerNick}, function() {
                $scope.blacklist = _.without($scope.blacklist, blacklist);
            });
        };
    }];

    FilterController.title = '买家过滤 - 自动评价';
    FilterController.template = 'rate/filterBuyer';
    FilterController.navClass = 'rateSetting';

    module.exports = FilterController;
});