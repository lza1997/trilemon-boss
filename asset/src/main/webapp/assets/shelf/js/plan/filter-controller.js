define(function (require, exports, module) {
    var FilterController = ['$scope', 'Restangular', function ($scope, Restangular) {
        $scope.items = [];

        Restangular.all('trilemon-360boss-shelf/sellercats/items').getList().then(function (data) {
            $scope.items = data;
        });
    }];

    FilterController.template = require('./filter.html');
    FilterController.title = "筛选宝贝";

    module.exports = FilterController;
});