/**
 * 自动评价应用的模块
 */
define(function(require, exports, module) {
    var rate = {
        controllers: {
            'rate.indexComment': require('./controller/index-comment')
        },
        factories: {
            'RateCommentSetting': require('./service/comment-setting')
        },
        templates: {
            'rate/indexComment': require('./template/index-comment.html')
        }
    };

    module.exports = rate;
});
