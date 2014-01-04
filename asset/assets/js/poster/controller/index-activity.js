/**
 * 活动列表
 */
define(function(require, exports, module) {

    var Controller = ['$scope', 'PosterActivity', 'Confirm', '$routeParams', '$location', function($scope, PosterActivity, Confirm, $routeParams, $location) {
        $scope.activities = PosterActivity.query();
        $scope.POSITION_TYPE = {
            1: '宝贝描述上方',
            2: '宝贝描述下方'
        };

        $scope.jumpPage = function(page) {
            $scope.activities = PosterActivity.query({page: page});
            $location.search({page: page});
            return $scope.activities.$promise;
        };

        $scope.publish = function(activity) {
            activity.$publish();
        };

        $scope.unpublish = function(activity) {
            activity.$unPublish();
        };

        // 删除
        $scope.remove = function(activity) {
            Confirm.open('确定要删除“' + activity.title + '”？').then(function() {
                activity.$remove(function() {
                    PosterActivity.refreshCurrPage($scope.activities.currPage, function(options) {
                        return $scope.jumpPage(options.page);
                    });
                });
            });
        };
    }];

    Controller.title = '海报列表 - 宝贝海报';
    Controller.template = 'poster/indexActivity';
    Controller.navClass = 'posterIndexActivity';

    module.exports = Controller;
});