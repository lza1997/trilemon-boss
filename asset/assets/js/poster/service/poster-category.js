/**
 * 店铺类型
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/poster/categories/:id';

        var PosterCategory = $resource(URL, {id: '@id'}, {

        });

        return PosterCategory;
    }];
});