define(function (require, exports, module) {
    var NewController = require('./controller/new-controller');
    var FilterController = require('./controller/filter-controller');
    var IndexController = require('./controller/index-controller');
    var Sellercat = require('./model/sellercat');
    var Item = require('./model/item');
    var Plan = require('./model/plan');

    module.exports = {
        controllers: {
            'plan.new': NewController,
            'plan.filter': FilterController,
            'plan.index':IndexController
        },
        factories: {
            'Sellercat': Sellercat,
            'Item': Item,
            'Plan': Plan
        }
    };
});
