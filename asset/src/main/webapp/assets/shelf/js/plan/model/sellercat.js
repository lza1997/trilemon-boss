/**
 * 卖家的类目
 */
define(function (require, exports, module) {
    var URL = 'shelf/sellercats';

    var Sellercat = ['Restangular', function (Restangular) {
        var Model = Restangular.all(URL);

        return Model;
    }];

    module.exports = Sellercat;
});