define(function (require, exports, module) {
    var NewController = require('./new-controller');
    var FilterController = require('./filter-controller');
    var Sellercat = require('./sellercat');
    var Item = require('./item');

    module.exports = {
        controllers: {
            'plan.new': NewController,
            'plan.filter': FilterController
        },
        factories: {
            'Sellercat': Sellercat,
            'Item': Item
        }
    };
});
