/**
 * 选择模板
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterTopic', 'PosterTemplate', '$routeParams', '$location', function($scope, PosterTopic, PosterTemplate, $routeParams, $location) {
        $scope.topics = PosterTopic.query();
        $scope.templates = PosterTemplate.query({topic: $routeParams.topic, category: $routeParams.category});
    }];

    Controller.title = '选择模板 - 宝贝海报';
    Controller.template = 'poster/selectTemplate';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});