/**
 * 自动评价应用的模块
 */
define(function(require, exports, module) {
    var rate = {
        controllers: {
            'rate.indexComment': require('./controller/index-comment'),
            'rate.filter': require('./controller/filter'),
            'rate.indexBuyerRate': require('./controller/index-rate')
        },
        factories: {
            'RateCommentSetting': require('./service/comment-setting'),
            'BuyerRate': require('./service/buyer-rate')
        },
        templates: {
            'rate/setting': require('./template/setting.html'),
            'rate/indexComment': require('./template/index-comment.html'),
            'rate/filterTrade': require('./template/filter-trade.html'),
            'rate/indexRate': require('./template/index-rate.html'),
            'rate/manualModal': require('./template/manual-modal.html')
        }
    };

    module.exports = rate;
});
