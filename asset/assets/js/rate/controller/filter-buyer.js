/**
 * 买家过滤
 */
define(function(require, exports, module) {
    var FilterController = ['$scope', 'Blacklist', 'RateSetting', '$timeout', function($scope, Blacklist, RateSetting, $timeout) {
        $scope.tab = 'filter';

        $scope.setting = RateSetting.get();

        $scope.saveSetting = function() {
            $scope.setting.$update(function() {
                $scope.saveSuccess = true;
                $timeout(function() {
                    $scope.saveSuccess = false;
                }, 3000);
            });
        };

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