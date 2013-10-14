define(function (require, exports, module) {
    var NewController = ['$scope', function ($scope) {

    }];

    NewController.template = require('./new.html');
    NewController.title = "创建计划";

    module.exports = NewController;
});