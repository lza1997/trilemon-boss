/**
 * 买家过滤
 */
define(function(require, exports, module) {
    var FilterController = ['$scope', 'Blacklist', function($scope, Blacklist) {
        $scope.tab = 'filter';

        $scope.blacklist = Blacklist.query();
        $scope.newBlacklist = new Blacklist();

        $scope.addBlacklist = function() {
            if ($scope.addForm.$valid) {
                $scope.newBlacklist.$save(function() {
                    $scope.blacklist = Blacklist.query();
                    $scope.newBlacklist = new Blacklist();
                    $scope.addForm.$setPristine();
                });
            }
        };

        $scope.removeBlacklist = function(blacklist) {
            blacklist.$remove(function() {
                $scope.blacklist = Blacklist.query();
            });
        };
    }];

    FilterController.title = '买家过滤 - 自动评价';
    FilterController.template = 'rate/filterBuyer';
    FilterController.navClass = 'rateSetting';

    module.exports = FilterController;
});