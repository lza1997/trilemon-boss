/**
 * 买家过滤的设置
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/rate/setting';

        var RateSetting = $resource(URL, null, {
            update: {
                method: 'PUT'
            }
        });


        return RateSetting;
    }];
});