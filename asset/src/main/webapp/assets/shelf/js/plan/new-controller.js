define(function (require, exports, module) {

    var NewController = ['$scope', 'Sellercat', function ($scope, Sellercat) {
        $scope.sellercats = [];

        Sellercat.getTree().then(function (result) {
            $scope.sellercats = result.tree;
            $scope.sellercatsNum = result.list.length;
            $scope.sellercatsChildNum = result.list.length - result.tree.length;

            // expand first cat which has child
            var firstCat = _.find(result.tree, function (cat) {
                return cat.children.length > 0;
            });
            firstCat.expand = true;
        });

        $scope.toggleCategory = function (category) {
            category.expand = !category.expand;
        };
    }];

    NewController.template = require('./new.html');
    NewController.title = "创建计划";

    module.exports = NewController;
});