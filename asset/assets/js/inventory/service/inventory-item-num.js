/**
 * 仓库
 */
define(function(require, exports, module) {
    module.exports = ['$resource', function($resource) {
        var URL = '/inventory/item-num';

        var InventoryItemNum = $resource(URL, null, {});

        return InventoryItemNum;
    }];
});