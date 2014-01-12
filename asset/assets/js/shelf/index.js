/**
 * 上下架应用的模块
 */
define(function(require, exports, module) {
    var angular = require('angularjs');

    var shelf = angular.module('shelf', []);

    shelf.seajsController(require('./controller/filter'));
    shelf.seajsController(require('./controller/form'));
    shelf.seajsController(require('./controller/index-plan-setting'));
    shelf.seajsController(require('./controller/distribution'));

    shelf.factory(require('./factory/plan-setting'));
    shelf.factory(require('./factory/plan-item'));
    shelf.factory(require('./factory/plan-setting-form'));

    module.exports = shelf;
});
