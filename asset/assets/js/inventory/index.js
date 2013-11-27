/**
 * 仓库宝贝上架的模块
 */
define(function(require, exports, module) {
    var inventory = {
        controllers: {
            'inventory.editSetting': require('./controller/edit-setting'),
            'inventory.showSetting': require('./controller/show-setting'),
            'inventory.distribution': require('./controller/distribution')
        },
        factories: {
            'InventorySetting': require('./service/inventory-setting'),
            'InventoryItemNum': require('./service/inventory-item-num'),
            'InventoryItem': require('./service/inventory-item')
        },
        templates: {
            'inventory/editSetting': require('./template/edit-setting.html'),
            'inventory/showSetting': require('./template/show-setting.html'),
            'inventory/distribution': require('./template/distribution.html'),
            'inventory/distributionModal': require('./template/distribution-modal.html')
        }
    };

    module.exports = inventory;
});
