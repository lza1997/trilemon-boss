/**
 * 店铺分类
 */
define(function(require, exports, module) {

    var IndexController = ['$scope', 'PosterCategory', 'PosterRecommendTemplate', 'PosterLastUsedTemplate', function($scope, PosterCategory, PosterRecommendTemplate, PosterLastUsedTemplate) {
        $scope.categories = PosterCategory.query();
        $scope.recommendTemplates = PosterRecommendTemplate.query();
        $scope.lastUsedTemplate = PosterLastUsedTemplate.get();
    }];

    IndexController.title = '选择店铺类型 - 宝贝海报';
    IndexController.template = 'poster/category';
    IndexController.navClass = 'posterSetting';

    module.exports = IndexController;
});