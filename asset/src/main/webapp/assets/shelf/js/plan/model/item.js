/**
 * 商品（宝贝）
 */
define(function (require, exports, module) {
    var URL = 'shelf/items';

    var Item = ['RestPageangular', function (RestPageangular) {
        var Model = RestPageangular.all(URL);

        return Model;
    }];

    module.exports = Item;
});