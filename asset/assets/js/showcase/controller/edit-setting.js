/**
 * 设置规则
 */
define(function(require, exports, module) {
    var EditRuleController = ['$scope', 'REST', 'SellerCat', function($scope, REST, SellerCat) {
        $scope.setting = {
            status: 2,
            excludeItemDelistingAfter: -1,
            excludeItemInventoryLt: 10,
            includeSellerCids: [],
            isEnabled: function() {
                return this.status === 2;
            }
        };

        // 设置规则开启
        $scope.enableSetting = function(flag) {
            $scope.setting.status = flag ? 2 : 1;
        };

        // 获取卖家的宝贝分类
        SellerCat.fetch({selectedCids: $scope.setting.includeSellerCids}).then(function(data) {
            $scope.sellerCats = data;
        });

        // 分类的父子联动选择
        $scope.check = function(cat) {
            SellerCat.checkSellerCat(cat, $scope.sellerCats);
        };

        // 展开或折叠父分类
        $scope.toggleSellerCat = SellerCat.toggleSellerCat;
    }];

    EditRuleController.template = "showcase/editSetting";
    EditRuleController.title = "橱窗推荐规则";

    module.exports = EditRuleController;
});