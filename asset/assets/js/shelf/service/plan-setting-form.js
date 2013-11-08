/**
 * 新建或修改计划，用于 Controller 的复用
 */
define(function(require, exports, module) {
    module.exports = ['REST', 'Flash', '$location', 'SellerCat', function(REST, Flash, $location, SellerCat) {

        return {
            // 向 controller 的 scope 注入方法与数据
            initScope: function($scope, planSetting) {
                $scope.planSetting = planSetting;
                $scope.sellerCats = [];

                // 将选中分类的 id 写入 planSetting 对象
                $scope.$watch('sellerCats', function saveCatIds(value) {
                    var selectedCids = _.chain(value).where({selected: true}).pluck('cid').value();
                    $scope.planSetting.includeSellerCids = selectedCids.join(',');
                }, true);

                // 获取卖家的宝贝分类
                SellerCat.fetch({selectedCids: $scope.includeSellerCids}).then(function(data) {
                    $scope.sellerCats = data;
                });

                // 分类的父子联动选择
                $scope.check = function(cat) {
                    SellerCat.checkSellerCat(cat, $scope.sellerCats);
                };

                // 展开或折叠父分类
                $scope.toggleSellerCat = SellerCat.toggleSellerCat;

                // 保存计划
                $scope.save = function() {
                    if (isValidate()) {
                        var method = $scope.planSetting.id ? 'put' : 'post';
                        var tip = $scope.planSetting.id ? '修改' : '创建';
                        $scope.planSetting[method]().then(function(data) {
                            Flash.success('计划 ' + $scope.planSetting.name + ' ' + tip + '成功！' +
                                '系统已经对宝贝进行了智能上架分配。可以<a href="#/shelf/plan-setting/' + data.id + '/distribution">手动设置上架时间</a>。');
                            $location.url('/plan-setting');
                        });
                    }
                };

                // 校验表单
                function isValidate() {
                    for (var field in $scope.form) {
                        if (field[0] !== '$' && $scope.form[field].$pristine) {
                            $scope.form[field].$setViewValue($scope.form[field].$modelValue);
                        }
                    }
                    return $scope.form.$valid;
                }
            }
        };
    }];
});