define(function (require, exports, module) {
    var NewController = require('./new-controller');
    var FilterController = require('./filter-controller');
    var Sellercat = require('./sellercat');

    module.exports = {
        controllers: {
            'plan.new': NewController,
            'plan.filter': FilterController
        },
        factories: {
            'Sellercat': Sellercat
        }
    };
});
