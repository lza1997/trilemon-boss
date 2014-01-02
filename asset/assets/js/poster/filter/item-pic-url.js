/**
 * 宝贝的图片地址
 */
define(function(require, exports, module) {

    module.exports = function() {

        return function(item, posterSize) {
            return item.picUrl + (posterSize === 750 ? '_b' : '_310x310' ) + '.jpg';
        };
    };
});