/**
 * 橱窗规则
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/showcase/setting';
        var PAUSE_URL = URL + '/pause';

        var ShowcaseSetting = $resource(URL, null, {
            save: {
                method: 'PUT'
            },
            pause: {
                method: 'POST',
                url: PAUSE_URL
            },
            resume: {
                method: 'DELETE',
                url: PAUSE_URL
            }
        });

        return ShowcaseSetting;
    }];
});