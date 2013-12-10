/**
 * 买家过滤
 */
define(function(require, exports, module) {
    var FilterController = ['$scope', function($scope) {
        $scope.tab = 'filter';
    }];

    FilterController.title = '评价内容 - 自动评价';
    FilterController.template = 'rate/setting';
    FilterController.navClass = 'rateSetting';

    module.exports = FilterController;
});