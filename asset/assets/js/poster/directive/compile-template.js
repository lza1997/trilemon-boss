/**
 * 预编译模板
 * <div compile-template="template" compile-output="xxx.result"></div>
 */
define(function(require, exports, module) {
    module.exports = ['$compile', '$parse', '$timeout', function($compile, $parse, $timeout) {
        return function(scope, element, attrs) {
            scope.$watch(function(scope) {
                    return scope.$eval(attrs.compileTemplate);
                }, function(value) {
                    element.html(value);
                    $compile(element.contents())(scope);

                    $timeout(function() {
                        if (attrs.compileOutput) {
                            $parse(attrs.compileOutput).assign(scope, element.html());
                        }
                    }, 0);
                }
            );
        };
    }];
});