/**
 * 仓库计划编辑
 */
define(function(require, exports, module) {
    var EditController = ['$scope', function($scope) {
        //$scope.modal = $modalInstance;

    }];

    EditController.template = 'inventory/editSetting';
    EditController.title = '计划详情';
    EditController.navClass = 'inventoryShow';

    module.exports = EditController;
});