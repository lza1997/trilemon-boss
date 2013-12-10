/**
 * 自动评价的评价内容
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/rate/comment-settings/:id';

        var CommentSetting = $resource(URL, {id: '@id'}, {
            create: {
                method: 'POST'
            },
            update: {
                method: 'PUT'
            }
        });

        return CommentSetting;
    }];
});