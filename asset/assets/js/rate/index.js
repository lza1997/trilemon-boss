/**
 * 自动评价应用的模块
 */
define(function(require, exports, module) {
    var rate = {
        controllers: {
            'rate.indexComment': require('./controller/index-comment'),
            'rate.filter': require('./controller/filter')
        },
        factories: {
            'RateCommentSetting': require('./service/comment-setting')
        },
        templates: {
            'rate/setting': require('./template/setting.html'),
            'rate/indexComment': require('./template/index-comment.html'),
            'rate/filterTrade': require('./template/filter-trade.html')
        }
    };

    module.exports = rate;
});
