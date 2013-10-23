define(function(require, exports, module) {
    var NewController = require('./controller/new-controller');
    var FilterController = require('./controller/filter-controller');
    var EditController = require('./controller/edit-controller');
    var IndexController = require('./controller/index-controller');
    var SellerCat = require('./service/seller-cat');
    var Item = require('./service/item');
    var PlanSetting = require('./service/plan-setting');
    var ItemFilter = require('./service/item-filter');
    var PlanSettingForm = require('./service/plan-setting-form');

    module.exports = {
        controllers: {
            'planSetting.new': NewController,
            'planSetting.filter': FilterController,
            'planSetting.index': IndexController,
            'planSetting.edit': EditController
        },
        factories: {
            'SellerCat': SellerCat,
            'Item': Item,
            'PlanSetting': PlanSetting,
            'ItemFilter': ItemFilter,
            'PlanSettingForm': PlanSettingForm
        }
    };
});
