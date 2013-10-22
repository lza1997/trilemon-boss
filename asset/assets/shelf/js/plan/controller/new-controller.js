define(function(require, exports, module) {

    var NewController = ['$scope', 'Sellercat', 'Plan', '$location', 'Flash', function($scope, Sellercat, Plan, $location, Flash) {
        $scope.sellerCats = [];
        $scope.plan = {autoAddNewItems: true};

        Sellercat.getList().then(function(data) {
            $scope.sellerCats = data;
        });

        $scope.planNewUrl = true;

        // 父子联动选择
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
        $scope.toggleSellerCat = function(sellercat) {
            sellercat.expand = !sellercat.expand;
        };

        // 保存计划
        $scope.save = function() {
            saveCatIds();
            Plan.post($scope.plan).then(function() {
                Flash.success('计划 ' + $scope.plan.name + ' 创建成功！');
                $location.url('/plan');
            });
        };

        // 跳转至筛选页面
        $scope.gotoFilter = function() {
            saveCatIds();
            Plan.tmpSave($scope.plan);
            $location.url('/plan/filter');
        };

        // 将选中分类的id写入 plan 对象
        function saveCatIds() {
            var selectedCids = _.chain($scope.sellerCats).where({selected: true}).pluck('cid').value();
            $scope.plan.includeCids = selectedCids.join(',');
        }
    }];

    NewController.template = require('../template/new.html');
    NewController.title = "创建计划";
    NewController.navClass = "planNew";

    module.exports = NewController;
});