/**
 * 仓库计划编辑
 */
define(function(require, exports, module) {
    var EditController = ['$scope', function($scope) {
        //$scope.modal = $modalInstance;

    }];

    EditController.template = 'inventory/editSetting';
    EditController.title = '编辑计划';
    EditController.navClass = 'inventoryEdit';

    module.exports = EditController;
});