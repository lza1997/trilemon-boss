/**
 * 商品（宝贝）
 */
define(function(require, exports, module) {
    var URL = 'shelf/plan-settings';

    var PlanSetting = ['RestPageangular', function(RestPageangular) {
        var Model = RestPageangular.all(URL);

        // 临时保存，在筛选页面会取出
        Model.tmpSave = function(data) {
            Model.tmpData = data;
        };

        return Model;
    }];

    module.exports = PlanSetting;
});