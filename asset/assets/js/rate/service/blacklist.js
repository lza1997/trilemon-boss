/**
 * 黑名单
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/rate/blacklist/:id';

        var Blacklist = $resource(URL, {id: '@id'}, {

        });


        return Blacklist;
    }];
});