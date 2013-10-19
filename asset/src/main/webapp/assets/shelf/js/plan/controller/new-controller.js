define(function (require, exports, module) {

    var NewController = ['$scope', 'Sellercat', 'Plan', '$location', function ($scope, Sellercat, Plan, $location) {
        $scope.sellercats = [];

        $scope.plan = {sellerCatIds: []};
        $scope.sellerCatIds = {};

        Sellercat.getTree().then(function (result) {
            $scope.sellercats = result.tree;
            $scope.sellercatsNum = result.list.length;
            $scope.sellercatsChildNum = result.list.length - result.tree.length;

            _.each(result.list, function (cat) {
                $scope.sellerCatIds[cat.cid] = false;
            })

            // 展开第一个有子类的分类
            var firstCat = _.find(result.tree, function (cat) {
                return cat.children.length > 0;
            });
            firstCat.expand = true;
        });

        // 父子联动选择
        $scope.selectSellerCat = function (sellercat) {
            _.each(sellercat.children, function (childSellerCat) {
                $scope.sellerCatIds[childSellerCat.cid] = $scope.sellerCatIds[sellercat.cid];
            });
        };

        // 展开或折叠父分类
        $scope.toggleSellerCat = function (sellercat) {
            sellercat.expand = !sellercat.expand;
        };

        // 跳转至筛选页面
        $scope.gotoFilter = function () {
            _.each($scope.sellerCatIds, function (v, k) {
                if (v) {
                    $scope.plan.sellerCatIds.push(k);
                }
            });

            Plan.save($scope.plan);
            $location.url('/plan/filter');
        };
    }];

    NewController.template = require('../template/new.html');
    NewController.title = "创建计划";

    module.exports = NewController;
});