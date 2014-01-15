// <a href="" ng-click=""> 在 IE7 下无法 preventDefault()
// 原因是 IE7 下获取 href 时有问题，而 Angular 未做针对性处理
$('body').on('click', 'a[href=""]', function(e) {
    e.preventDefault();
});
// 稍后被使用
var IE7_FIX_CONFIG = ['$provide', '$sceDelegateProvider', function($provide, $sceDelegateProvider) {

    // jQLite 的 addClass/removeClass 不兼容 IE7
    $provide.decorator('$animate', ['$delegate', '$timeout', function($delegate, $timeout) {
        $delegate.addClass = function(element, className, done) {
            element.addClass(className);
            done && $timeout(done, 0, false);
        };

        $delegate.removeClass = function(element, className, done) {
            element.removeClass(className);
            done && $timeout(done, 0, false);
        };
        return $delegate;
    }]);

    // 仍然与 href 有关系，这里只能放松规则
    $sceDelegateProvider.resourceUrlWhitelist(['self', '**']);
}];