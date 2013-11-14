/**
 * 宝贝分类
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {

        var Sellercat = $resource('/showcase/sellercats', null, {
            query: {
                method: 'GET',
                isArray: true,
                'transformRequest': function(data, headersGetter) {
                    return data;
                },
                interceptor: {
                    // 整理服务器数据，进行一些预处理
                    'response': function(response) {
                        var data = response.resource;

                        // 服务器数据再组装
                        _.each(data, function(item) {
                            _.extend(item, item.sellerCat);
                            delete item.sellerCat;
                        });

                        // 展开第一个有子分类的
                        var firstHasChild = _.find(data, function(cat) {
                            return _.where(data, {parentCid: cat.cid}).length > 0;
                        });
                        if (firstHasChild) {
                            firstHasChild.expand = true;
                        }

                        // 计算一级分类的数量
                        data.parentLength = _.where(data, {parentCid: 0}).length;

                        // 为每个分类增加方法
                        _.each(data, function(item) {
                            item.toggleExpand = function() {
                                this.expand = !this.expand;
                            };
                            item.toggleChecked = function() {
                                toggleChecked(this, data);
                            };
                        });

                        return response.resource;
                    }
                }
            }
        });

        // 用于数据回填
        Sellercat.setCheckedByIds = function(sellerCats, cids) {
            if (!angular.isArray(cids)) {
                cids = (cids || '').split(',');
            }
            _.each(sellerCats, function(cat) {
                cat.wasChecked = cat.checked = _.include(cids, cat.cid + '');
            });
        };

        // 切换分类选中状态时，进行父子联动选择
        function toggleChecked(currCat, sellerCats) {
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
        }

        return Sellercat;
    }];
});