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
                {name: '固定推荐', url: '/showcase/include-item', navClass: 'showcaseInclude'},
                {name: '橱窗宝贝', url: '/showcase/showcase-item', navClass: 'showcaseItem'}
            ]
        },
        {
            name: '仓库宝贝上架',
            url: '/inventory',
            children: [
                {name: '修改计划', url: '/inventory/setting/edit', navClass: 'inventoryEdit'},
                {name: '计划详情', url: '/inventory/setting', navClass: 'inventoryShow'}
            ]
        },
        {
            name: '自动评价',
            url: '/rate',
            children: [
                {name: '评价设置', url: '/rate/comments', navClass: 'rateSetting'},
                {name: '中差评', url: '/rate/buyer-rates', navClass: 'rateBuyerRate'},
                {name: '统计', url: '/rate/sx', navClass: 'rate'}
            ]
        },
        {
            name: '宝贝海报',
            url: '/poster',
            children: [
                {name: '制作海报', url: '/poster/category', navClass: 'posterSetting'},
                {name: '海报列表', url: '/poster/poster', navClass: 'posterPoster'},
                {name: '海报模板', url: '/poster/template', navClass: 'posterTemplate'}
            ]
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