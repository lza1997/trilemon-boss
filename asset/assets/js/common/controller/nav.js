/**
 * 导航栏
 */
angular.module('common').controller('nav', ['$scope', '$location', '$rootScope', function($scope, $location, $rootScope) {
    $scope.navs = [
        {
            name: '上下架',
            url: '/shelf',
            children: [
                {name: '计划列表', url: '/shelf/plan-setting', navClass: 'shelfIndex'},
                {name: '创建计划', url: '/shelf/plan-setting/new', navClass: 'shelfNew'}
            ]
        },
        {
            name: '橱窗推荐',
            url: '/showcase',
            children: [
                {name: '橱窗规则', url: '/showcase/setting/edit', navClass: 'showcaseEdit'},
                {name: '固定推荐', url: '/showcase/plan', navClass: 'showcase'},
                {name: '橱窗宝贝', url: '/showcase/showcase-item', navClass: 'showcaseItem'}
            ]
        },
        {
            name: 'CMS',
            url: '/sb'
        }
    ];

    $scope.$watch(function() {
        return $location.path();
    }, function(url) {
        $scope.currNav = _.find($scope.navs, function(nav) {
            return url.indexOf(nav.url) === 0;
        });
    });
}]);