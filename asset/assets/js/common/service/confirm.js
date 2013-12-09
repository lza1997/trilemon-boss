/**
 * 确认框
 */
angular.module('common').factory('Confirm', ['$modal', function($modal) {
    return {
        open: function(text) {
            var modal = $modal.open({
                template: '<div class="modal-dialog confirm-dialog">' +
                    '<div class="modal-content">' +
                    '<div class="modal-body">{{ text }}</div>' +
                    '<div class="modal-footer">' +
                    '<button type="button" class="btn btn-primary" ng-click="modal.close()">确定</button>' +
                    '<button type="button" class="btn btn-default" ng-click="modal.dismiss()">取消</button>' +
                    '</div>' +
                    '</div>' +
                    '</div>',
                controller: ['$scope', '$modalInstance', function($scope, $modalInstance) {
                    $scope.text = text;
                    $scope.modal = $modalInstance;
                }]
            });
            return modal.result;
        }
    };
}]);