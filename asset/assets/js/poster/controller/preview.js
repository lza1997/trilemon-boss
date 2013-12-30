/**
 * 预览海报
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterActivity', 'PosterTemplate', '$routeParams', '$location', '$compile', function($scope, PosterActivity, PosterTemplate, $routeParams, $location, $compile) {
        $scope.activity = PosterActivity.get({id: $routeParams.activityId, detail: true}, function(data) {
            $scope.items = _.map(data.activityItems, function(item){
                _.extend(item, item.item);
                delete item.item;
                return item;
            });
            $scope.template = data.template;
        });
    }];

    Controller.title = '预览 - 宝贝海报';
    Controller.template = 'poster/preview';
    Controller.navClass = 'posterSetting';

    module.exports = Controller;
});
