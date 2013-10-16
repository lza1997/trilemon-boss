/**
 * 卖家的类目
 */
define(function (require, exports, module) {
    var URL = '/sellercats';

    var Sellercat = ['restangular', function (Restangular) {

        var Model = Restangular.all(URL);

//        Model.getList = function () {
//
//        };

        return Model;
    }];

    module.exports = Sellercat;
});