/**
 * 新建或修改计划，用于 Controller 的复用
 */
define(function(require, exports, module) {
    module.exports = ['SellerCat', 'Flash', '$location', function(SellerCat, Flash, $location) {

        return {
            // 向 controller 的 scope 注入方法与数据
            initScope: function($scope, planSetting) {
                $scope.sellerCats = [];
                $scope.planSetting = planSetting;

                SellerCat.getList().then(function(data) {
                    $scope.sellerCats = data;
                });

                // 分类的父子联动选择
                $scope.changeSelected = function(sellerCat) {
                    // 联动所有子分类
                    if (sellerCat.parentCid === 0) {
                        _.chain($scope.sellerCats).where({parentCid: sellerCat.cid}).each(function(childSellerCat) {
                            childSellerCat.selected = sellerCat.selected;
                        });
                    }
                    // 联动父分类，所有兄弟都选中时才选中父分类
                    else {
                        var parentCat = _.findWhere($scope.sellerCats, {cid: sellerCat.parentCid});
                        var childCats = _.where($scope.sellerCats, {parentCid: sellerCat.parentCid});
                        parentCat.selected = _.every(childCats, function(cat) {
                            return cat.selected;
                        });
                    }
                };

                // 展开或折叠父分类
                $scope.toggleSellerCat = function(sellerCat) {
                    sellerCat.expand = !sellerCat.expand;
                };

                // 保存计划
                $scope.save = function() {
                    saveCatIds();
                    if ($scope.planSetting.id) {
                        $scope.planSetting.put().then(function() {
                            Flash.success('计划 ' + $scope.planSetting.name + ' 修改成功！');
                            $location.url('/plan-setting');
                        });
                    }
                    else {
                        $scope.planSetting.post().then(function() {
                            Flash.success('计划 ' + $scope.planSetting.name + ' 创建成功！');
                            $location.url('/plan-setting');
                        });
                    }
                };

                // 跳转至筛选页面
                $scope.gotoFilter = function() {
                    saveCatIds();
                    PlanSetting.tmpSave($scope.planSetting);
                    $location.url('/plan-setting/filter');
                };

                // 将选中分类的id写入 planSetting 对象
                function saveCatIds() {
                    var selectedCids = _.chain($scope.sellerCats).where({selected: true}).pluck('cid').value();
                    $scope.planSetting.includeCids = selectedCids.join(',');
                }
            }
        };
    }];
});