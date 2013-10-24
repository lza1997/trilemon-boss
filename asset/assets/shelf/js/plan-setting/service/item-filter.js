/**
 * 排除商品，用于几处 Controller 的复用
 */
define(function(require, exports, module) {
    module.exports = ['RestPageangular', 'URL', function(RestPageangular,URL) {

        // 获取宝贝列表，可以传入关键词、页码等
        function getItems($scope, planSetting, options) {
            options = options || {};
            if (planSetting.id) {
                options.pid = planSetting.id; // 用于编辑
            }
            else {
                options.cids = planSetting.includeCids.split(',');  // 用于创建，上一步选中的分类
            }

            RestPageangular.all(URL.ITEM).getList(options).then(function(data) {
                // 将临时保存的被排除宝贝数据合并
                _.each(data, function(item) {
                    item.exclude = _.contains($scope.excludeIds, item.numIid);
                });

                $scope.items = data;
            });
        }

        return {
            // 向 controller 的 scope 注入方法与数据
            initScope: function($scope, planSetting) {
                $scope.items = [];
                $scope.planNewUrl = true;
                $scope.lastSearchKey;  // 上一次搜索的关键词
                // 被排除的宝贝 id
                if (planSetting.id) {
                    $scope.excludeIds = _.map(planSetting.excludeItemIids.split(','), function(v) {
                        return parseInt(v, 10);
                    });
                }
                else {
                    $scope.excludeIds = [];
                }

                getItems($scope, planSetting); // 初始化时取第一页数据

                // 搜索
                $scope.search = function() {
                    getItems($scope, planSetting, {key: $scope.searchKey});
                    $scope.lastSearchKey = $scope.searchKey;
                };

                // 处理分页
                $scope.jumpPage = function(page) {
                    getItems($scope, planSetting, {page: page, key: $scope.lastSearchKey});
                };

                // 排除宝贝
                $scope.setExclude = function(item, flag) {
                    item.exclude = flag;
                    if (flag) {
                        $scope.excludeIds.push(item.numIid);
                    }
                    else {
                        $scope.excludeIds = _.without($scope.excludeIds, item.numIid);
                    }
                };

                // 保存
                $scope.save = function() {
                    planSetting.excludeItemIids = $scope.excludeIds.join(',');
                    if (planSetting.id) {
                        return planSetting.put();
                    }
                    else {
                        return planSetting.post();
                    }
                };
            }
        };
    }];
});