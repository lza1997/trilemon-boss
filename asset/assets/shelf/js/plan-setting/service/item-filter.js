/**
 * 商品（宝贝）
 */
define(function(require, exports, module) {
    module.exports = ['Item', 'PlanSetting', function(Item, PlanSetting) {
        var lastSearchKey;  // 上一次搜索的关键词
        var excludeIds = [];  // 被排除的宝贝 id

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems($scope, planSetting, options) {
            options = options || {};
            options.cids = planSetting.includeCids.split(',');  // 上一步选中的分类

            Item.getList(options).then(function(data) {
                // 将临时保存的被排除宝贝数据合并
                _.each(data, function(item) {
                    item.exclude = _.contains(excludeIds, item.numIid);
                });

                $scope.items = data;
            });
        }

        return {
            initScope:function($scope, planSetting) {
                var _this = this;

                $scope.items = [];
                $scope.planNewUrl = true;

                getItems($scope, planSetting); // 初始化时取第一页数据

                // 搜索
                $scope.search = function() {
                    getItems($scope, planSetting, {key: $scope.searchKey});
                    lastSearchKey = $scope.searchKey;
                };

                // 处理分页
                $scope.jumpPage = function(page) {
                    getItems($scope, planSetting, {page: page, key: lastSearchKey});
                };

                // 排除宝贝
                $scope.setExclude = function(item, flag) {
                    item.exclude = flag;
                    if (flag) {
                        excludeIds.push(item.numIid);
                    }
                    else {
                        excludeIds = _.without(excludeIds, item.numIid);
                    }
                };

                // 保存
                $scope.save = function() {
                    var promise;
                    planSetting.excludeItemIids = excludeIds.join(',');
                    if(planSetting.id){
                        promise = planSetting.put();
                    }else{
                        promise = PlanSetting.post(planSetting);
                    }
                    return promise;
                };
            }
        };
    }];

    //    // 初始化
    //    $scope.init = function() {
    //        // 没有临时的 Plan 数据时跳回页面
    //        if (!PlanSetting.tmpData) {
    //            $location.url('/plan/new');
    //        }
    //
    //        $scope.items = [];
    //        $scope.excludeIds = [];  // 被排除的宝贝 id
    //        $scope.planNewUrl = true;
    //        getItems(); // 初始化时取第一页数据
    //    };
    //
    //    // 搜索
    //    var searchKey = '';
    //
    //
    //    // 处理分页
    //    $scope.jumpPage = function(page) {
    //        getItems({page: page, key: searchKey});
    //    };
    //
    //    // 排除
    //    $scope.setExclude = function(item, flag) {
    //        item.exclude = flag;
    //        if (flag) {
    //            $scope.excludeIds.push(item.numIid);
    //        }
    //        else {
    //            $scope.excludeIds = _.without($scope.excludeIds, item.numIid);
    //        }
    //    };
    //
    //    $scope.save = function() {
    //        PlanSetting.tmpData.excludeItemIids = $scope.excludeIds.join(',');
    //        PlanSetting.post(PlanSetting.tmpData).then(function() {
    //            Flash.success('计划 ' + PlanSetting.tmpData.name + ' 创建成功！');
    //            $location.url('/plan');
    //        });
    //    };
});