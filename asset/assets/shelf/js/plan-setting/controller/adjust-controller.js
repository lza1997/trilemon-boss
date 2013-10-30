/**
 * 手动设置上架时间
 */
define(function(require, exports, module) {

    var AdjustController = ['$scope', 'REST', '$routeParams', function($scope, REST, $routeParams) {
        //$scope.

    }];

    AdjustController.template = require('../template/adjust.html');
    AdjustController.title = "设置上架时间";

    module.exports = AdjustController;
});