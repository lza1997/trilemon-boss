/**
 * 商品（宝贝）
 */
define(function (require, exports, module) {
    var URL = '/shelf/plans';

    var Plan = ['$http', '$q', function ($http, $q) {

        var Model = {};

        // 临时保存，在筛选页面会取出
        Model.tmpSave = function (data) {
            Model.tmpData = data;
        };

        return Model;
    }];

    module.exports = Plan;
});