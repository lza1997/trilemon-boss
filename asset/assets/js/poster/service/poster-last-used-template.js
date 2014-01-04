/**
 * 店铺类型
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/poster/last-used-template';

        var PosterLastUsedTemplate = $resource(URL, null, {});

        return PosterLastUsedTemplate;
    }];
});