/**
 * 商品（宝贝）
 */
define(function(require, exports, module) {

    var Confirm = ['$modal', function($modal) {

        return {
            open: function(text) {
                var modal = $modal.open({
                    template: require('../template/confirm.html'),
                    controller: ['$scope', '$modalInstance', function($scope, $modalInstance){
                        $scope.text = text;
                        $scope.modal = $modalInstance;
                    }]
                });
                return modal.result;
            }
        };
    }];

    module.exports = Confirm;
});