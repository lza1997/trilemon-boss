/**
 * 分页组件
 * <pagination items="xxx" pagerClick="goto(page)"></pagination>
 */
angular.module('ui.bootstrap.pagination', []).directive('pagination', function() {
    var WINDOW_SIZE = 2;
    var OMIT_STR = '...';

    return {
        restrict: 'E',
        replace: true,
        transclude: true,
        scope: {
            items: '=',
            pagerClick: '&'
        },
        template: '<ul class="pagination" ng-show="isShow">'
            + '<li ng-class="{disabled: currPage == 1}"><a href="" ng-click="jump(currPage-1)">上一页</a></li>'
            + '<li ng-repeat="page in pages" ng-class="{active: (page == currPage), disabled: (page == omit)}"><a href="" ng-click="jump(page)">{{page}}</a></li>'
            + '<li ng-class="{disabled: currPage == totalPage}"><a href="" ng-click="jump(currPage+1)">下一页</a></li>'
            + '</ul>',

        link: function(scope, element, attrs) {
            scope.omit = OMIT_STR;

            scope.$watchCollection('items', function(items) {
                scope.isShow = items && items.totalPage && items.totalPage > 1;
                if (scope.isShow) {
                    scope.currPage = items.currPage;
                    scope.totalPage = items.totalPage;

                    // 不需要显示所有页数，只需要在当前页附近开一个“窗口”
                    scope.pages = [1];
                    if (scope.currPage > 1 + WINDOW_SIZE + 1) {
                        scope.pages.push(OMIT_STR);
                    }

                    var leftPage = Math.max(2, scope.currPage - WINDOW_SIZE);
                    var rightPage = Math.min(scope.totalPage - 1, scope.currPage + WINDOW_SIZE);
                    scope.pages = scope.pages.concat(_.range(leftPage, rightPage + 1));

                    if (scope.currPage < scope.totalPage - WINDOW_SIZE - 1) {
                        scope.pages.push(OMIT_STR);
                    }
                    scope.pages.push(scope.totalPage);
                }
            });

            // 跳转
            scope.jump = function(page) {
                if (page > scope.totalPage || page < 1 || page === OMIT_STR) {
                    return;
                }
                scope.pagerClick({page: page});
            };
        }
    };
});