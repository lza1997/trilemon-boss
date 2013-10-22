define(function(require, exports, module) {
    var NewController = require('./controller/new-controller');
    var FilterController = require('./controller/filter-controller');
    var IndexController = require('./controller/index-controller');
    var Sellercat = require('./model/sellercat');
    var Item = require('./model/item');
    var PlanSetting = require('./model/plan-setting');

    module.exports = {
        controllers: {
            'planSetting.new': NewController,
            'planSetting.filter': FilterController,
            'planSetting.index': IndexController
        },
        factories: {
            'Sellercat': Sellercat,
            'Item': Item,
            'PlanSetting': PlanSetting
        }
    };
});
