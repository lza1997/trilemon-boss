/**
 * 店铺类型
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/poster/topics/:id';

        var PosterTopics = $resource(URL, {id: '@id'}, {

        });

        return PosterTopics;
    }];
});