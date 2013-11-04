/**
 * 修正 IE7 下动画的相关问题
 */
var AnimateIE7Fix = ['$provide', '$animateProvider', function($provide, $animateProvider) {
    $provide.decorator('$animate', ['$delegate', '$injector', '$sniffer', '$rootElement', '$timeout', '$rootScope',
        function($delegate, $injector, $sniffer, $rootElement, $timeout, $rootScope) {


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

}];