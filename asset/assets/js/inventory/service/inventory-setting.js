/**
 * 仓库
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/inventory/setting';
        var PAUSE_URL = URL + '/pause';

        var InventorySetting = $resource(URL, null, {
            create: {
                method: 'POST'
            },
            update: {
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

        return InventorySetting;
    }];
});