/**
 * 预编译模板
 * <div compile="template"></div>
 */
define(function(require, exports, module) {
    module.exports = ['$compile', function($compile) {
        return function(scope, element, attrs) {
            scope.$watch(function(scope) {
                    return scope.$eval(attrs.compile);
                }, function(value) {
                    element.html(value);
                    $compile(element.contents())(scope);
                }
            );
        };
    }];
});