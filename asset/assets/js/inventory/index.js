/**
 * 仓库宝贝上架的模块
 */
define(function(require, exports, module) {
    var inventory = {
        controllers: {
            'inventory.editSetting': require('./controller/edit-setting')
        },
        templates: {
            'inventory/editSetting': require('./template/edit-setting.html'),
            'inventory/showSetting': require('./template/show-setting.html')
        },
        factories: {
            'InventorySetting': require('./service/inventory-setting'),
            'InventoryItemNum': require('./service/inventory-item-num')
        }
    };

    module.exports = inventory;
});
