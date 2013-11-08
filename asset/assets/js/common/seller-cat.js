/**
 * 宝贝分类的选择
 */
angular.module('common').factory('SellerCat', ['REST', '$q', function(REST, $q) {
    var SellerCat = {

        // 获取所有分类
        // options.selectedCids 已经选择的分类 ID
        fetch: function(options) {
            var defer = $q.defer();
            REST.SELLER_CAT.getList().then(function(data) {
                // 展开第一个有子分类的 TODO:BUG
                var firstChild = _.find(data, function(cat) {
                    return cat.parentCid !== 0;
                });
                _.findWhere(data, {cid: firstChild.parentCid}).expand = true;

                // 显示页面时回填
                _.each(data, function(cat) {
                    cat.wasSelected = cat.selected = _.include(options.selectedCids, cat.cid + '');
                });
                defer.resolve(data);
            });
            return defer.promise;
        },

        // 选中分类时，进行父子联动选择
        checkSellerCat: function(currCat, sellerCats) {
            // 联动所有子分类
            if (currCat.parentCid === 0) {
                _.chain(sellerCats).where({parentCid: currCat.cid}).each(function(childSellerCat) {
                    if (childSellerCat.planned && !childSellerCat.wasSelected) {
                        return;
                    }
                    childSellerCat.selected = currCat.selected;
                });
            }
            // 联动父分类，所有兄弟都选中时才选中父分类
            else {
                var parentCat = _.findWhere(sellerCats, {cid: currCat.parentCid});
                var childCats = _.where(sellerCats, {parentCid: currCat.parentCid});
                parentCat.selected = _.every(childCats, function(cat) {
                    return cat.selected;
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


