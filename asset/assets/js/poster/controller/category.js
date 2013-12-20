/**
* 店铺分类
*/
define(function(require, exports, module) {

    var IndexController = ['$scope', 'PosterCategory', '$location', function($scope, PosterCategory, $location) {
        $scope.categories = PosterCategory.query();
    }];

    IndexController.title = '选择店铺类型 - 宝贝海报';
    IndexController.template = 'poster/category';
    IndexController.navClass = 'posterSetting';

    module.exports = IndexController;
});