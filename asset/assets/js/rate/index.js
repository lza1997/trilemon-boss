/**
 * 自动评价应用的模块
 */
define(function(require, exports, module) {
    var rate = {
        controllers: {
            'rate.indexComment': require('./controller/index-comment'),
            'rate.filterBuyer': require('./controller/filter-buyer'),
            'rate.indexBuyerRate': require('./controller/index-rate')
        },
        factories: {
            'RateCommentSetting': require('./service/comment-setting'),
            'BuyerRate': require('./service/buyer-rate'),
            'Blacklist': require('./service/blacklist')
        },
        templates: {
            'rate/setting': require('./template/setting.html'),
            'rate/indexComment': require('./template/index-comment.html'),
            'rate/filterBuyer': require('./template/filter-buyer.html'),
            'rate/indexRate': require('./template/index-rate.html'),
            'rate/manualModal': require('./template/manual-modal.html')
        }
    };

    module.exports = rate;
});
