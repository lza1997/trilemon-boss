/**
 * 设置规则
 */
define(function(require, exports, module) {
    var EditRuleController = ['$scope', 'REST', 'SellerCat', 'SETTING_STATUS', function($scope, REST, SellerCat, SETTING_STATUS) {
        REST.SHOWCASE_SETTING.get().then(function(data) {
            //            $scope.setting = {
            //                status: 2,
            //                excludeItemDelistingAfter: -1,
            //                excludeItemInventoryLt: 10,
            //                includeSellerCids: [],
            //                isEnabled: function() {
            //                    return this.status === 2;
            //                }
            //            };
            $scope.setting = data;
            $scope.setting.isPaused = data.status !== SETTING_STATUS.RUNNING;

        });

        // 设置规则开启
        $scope.setPaused = function(flag) {
            var method = flag ? 'post' : 'remove';
            REST.SHOWCASE_SETTING.one('pause')[method]().then(function(data) {
                $scope.setting = data;
                $scope.setting.isPaused = data.status === SETTING_STATUS.PAUSED;
            });
        };

//        // 获取卖家的宝贝分类
//        SellerCat.fetch({selectedCids: $scope.setting.includeSellerCids}).then(function(data) {
//            $scope.sellerCats = data;
//        });
//
//        // 分类的父子联动选择
//        $scope.check = function(cat) {
//            SellerCat.checkSellerCat(cat, $scope.sellerCats);
//        };
//
//        // 展开或折叠父分类
//        $scope.toggleSellerCat = SellerCat.toggleSellerCat;
    }];

    EditRuleController.template = "showcase/editSetting";
    EditRuleController.title = "橱窗推荐规则";
    EditRuleController.navClass = "showcaseEdit";

    module.exports = EditRuleController;
});