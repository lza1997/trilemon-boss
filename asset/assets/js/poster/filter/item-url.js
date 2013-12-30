/**
 * 宝贝的 URL 地址
 */
define(function(require, exports, module) {

    module.exports = function() {

        return function(item) {
            return 'http://item.taobao.com/item.htm?id=' + item.numIid;
        };
    };
});