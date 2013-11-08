/**
 * 设置规则
 */
define(function(require, exports, module) {
    var EditRuleController = ['$scope', 'REST', function($scope, REST) {
        $scope.hasRule = false;

        // 获取卖家的宝贝分类
        REST.SELLER_CAT.getList().then(function(data) {
            // 展开第一个有子分类的
            var firstChild = _.find(data, function(cat) {
                return cat.parentCid !== 0;
            });
            _.findWhere(data, {cid: firstChild.parentCid}).expand = true;

            // 显示页面时回填
            _.each(data, function(cat) {
                cat.wasSelected = cat.selected = _.include($scope.includeSellerCids, cat.cid + '');
            });

            $scope.sellerCats = data;
        });

        $scope.createRule = function() {
            $scope.hasRule = true;
        };
    }];

    EditRuleController.template = "showcase/edit";
    EditRuleController.title = "橱窗推荐规则";

    module.exports = EditRuleController;
});