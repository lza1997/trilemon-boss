/**
 * 选择模板
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterTopic', 'PosterTemplate', '$routeParams', '$location', function($scope, PosterTopic, PosterTemplate, $routeParams, $location) {
        $scope.topics = PosterTopic.query();
        $scope.$routeParams = $routeParams;

        getItems();

        $scope.getByTopic = function(topic) {
            getItems({topic: topic || '', page: 1});
        };

        $scope.jumpPage = function(page) {
            getItems({page: page});
        };

        // 获取模板列表，可以传入分类、页码等
        function getItems(options) {
            // 合并 URL 上的参数，并将新参数再次写入 URL
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);

            $scope.templates = PosterTemplate.query(options);
            return $scope.templates.$promise;
        }
    }];

    Controller.title = '选择模板 - 宝贝海报';
    Controller.template = 'poster/selectTemplate';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});