/**
 * 宝贝分类的选择
 */
angular.module('common').factory('SellerCat', ['$q', function($q) {
    var SellerCat = {
        setREST: function(REST) {
            this.REST = REST;
        },

        // 获取所有分类
        // options.selectedCids 已经选择的分类 ID
        fetch: function(options) {
            options = _.defaults(options || {}, {selectedCids: []});

            var defer = $q.defer();
            this.REST.getList().then(function(data) {
                // 服务器数据再组装
                data = _.map(data, function(item) {
                    return _.extend(item.sellerCat, _.omit(item, 'sellerCat'));
                });

                // 展开第一个有子分类的
                var firstHasChild = _.find(data, function(cat) {
                    return _.where(data, {parentCid: cat.cid}).length > 0;
                });
                if (firstHasChild) {
                    firstHasChild.expand = true;
                }

                // 显示页面时回填
                _.each(data, function(cat) {
                    cat.wasSelected = cat.selected = _.include(options.selectedCids, cat.cid + '');
                });

                // 一级分类的数量
                data.parentLength = _.where(data, {parentCid: 0}).length;

                defer.resolve(data);
            });
            return defer.promise;
        },

        // 选中分类时，进行父子联动选择
        checkSellerCat: function(currCat, sellerCats) {
            // 联动所有子分类
            if (currCat.parentCid === 0) {
                _.chain(sellerCats).where({parentCid: currCat.cid}).each(function(childSellerCat) {
                    if (childSellerCat.used && !childSellerCat.wasChecked) {
                        return;
                    }
                    childSellerCat.checked = currCat.checked;
                });
            }
            // 联动父分类，所有兄弟都选中时才选中父分类
            else {
                var parentCat = _.findWhere(sellerCats, {cid: currCat.parentCid});
                var childCats = _.where(sellerCats, {parentCid: currCat.parentCid});
                parentCat.checked = _.every(childCats, function(cat) {
                    return cat.checked;
                });
            }
        },

        // 展开或折叠父分类
        toggleSellerCat: function(sellerCat) {
            sellerCat.expand = !sellerCat.expand;
        }
    };

    return SellerCat;
}]);


