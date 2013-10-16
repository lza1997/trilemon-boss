define(function (require, exports, module) {

    var NewController = ['$scope', 'Sellercat', function ($scope, Sellercat) {

        $scope.sellercats = [];

        Sellercat.getList().then(function (data) {
            $scope.sellercats = data;
        });

        $scope.toggleCategory = function (category) {
            category.collapse = !category.collapse;
        };
    }];

    NewController.template = require('./new.html');
    NewController.title = "创建计划";

    module.exports = NewController;
});