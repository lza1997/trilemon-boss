/**
 * 店铺类型
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/poster/recommend-templates/:id';

        var PosterRecommendTemplate = $resource(URL, {id: '@id'}, {});

        return PosterRecommendTemplate;
    }];
});