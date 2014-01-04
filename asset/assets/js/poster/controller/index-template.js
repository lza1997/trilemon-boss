/**
 * 选择模板
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterTopic', 'PosterTemplate', '$rootScope', '$routeParams', '$location', function($scope, PosterTopic, PosterTemplate, $rootScope, $routeParams, $location) {
        // 初始化
        $scope.init = function() {
            $scope.$routeParams = $routeParams;
            // 制作或是列表
            if ($routeParams.category) {
                $scope.nav = 'setting';
                $rootScope.navClass = 'posterSetting';
                $rootScope.title = '选择模板 - 宝贝海报';
                $scope.topics = PosterTopic.query();
            }
            else {
                $scope.nav = 'list';
                $rootScope.navClass = 'posterIndexTemplate';
                $rootScope.title = '海报模板 - 宝贝海报';
                $scope.type = $routeParams.type;
            }
            getTemplates();
        };

        $scope.init();

        // 收藏或取消
        $scope.setFav = function(template, flag) {
            var method = flag ? '$fav' : '$unfav';
            template[method]();
        };

        $scope.getByType = function(type) {
            getTemplates({type: type, page: 1});
        };

        $scope.getByTopic = function(topic) {
            getTemplates({topic: topic || '', page: 1});
        };

        $scope.jumpPage = function(page) {
            getTemplates({page: page});
        };

        // 获取模板列表，可以传入分类、页码等
        function getTemplates(options) {
            // 合并 URL 上的参数，并将新参数再次写入 URL
            options = _.defaults(options || {}, $routeParams);
            $location.search(options);

            $scope.templates = PosterTemplate.query(options);
            return $scope.templates.$promise;
        }
    }];

    Controller.template = 'poster/indexTemplate';

    module.exports = Controller;
});