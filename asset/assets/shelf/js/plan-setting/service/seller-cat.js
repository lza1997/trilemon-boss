/**
 * 卖家的类目
 */
define(function (require, exports, module) {
    var URL = 'shelf/sellercats';

    var SellerCat = ['Restangular', function (Restangular) {
        var Model = Restangular.all(URL);

        return Model;
    }];

    module.exports = SellerCat;
});