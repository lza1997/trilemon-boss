/**
 * 评价内容列表
 */
define(function(require, exports, module) {
    var IndexController = ['$scope', 'RateCommentSetting', 'Confirm', function($scope, RateCommentSetting, Confirm) {
        $scope.tab = 'comment';

        $scope.settings = RateCommentSetting.query();
        $scope.newSetting = new RateCommentSetting({content: ''});

        // 添加
        $scope.create = function() {
            if ($scope.addForm.$invalid) {
                // set dirty to show error
                $scope.addForm.content.$setViewValue($scope.addForm.content.$modelValue);
                return;
            }
            $scope.newSetting.$create(function(data) {
                $scope.settings.push(data);
                $scope.newSetting = new RateCommentSetting({content: ''});
            });
        };

        // 编辑
        var originalContent;
        $scope.edit = function(setting) {
            _.each($scope.settings, function(s) {
                if (s.isEdit) {
                    $scope.cancelEdit(s);
                }
            });
            setting.isEdit = true;
            originalContent = setting.content;
        };
        $scope.cancelEdit = function(setting) {
            setting.content = originalContent;
            setting.isEdit = false;
        };
        $scope.update = function(setting) {
            if ($.trim(setting.content).length > 0) {
                setting.$update();
            }
        };

        // 删除
        $scope.remove = function(setting) {
            Confirm.open('确定删除“' + setting.content.substr(0, 9) + '...”？').then(function() {
                setting.$remove(function() {
                    $scope.settings = _.without($scope.settings, setting);
                });
            });
        };
    }];

    IndexController.title = '评价内容 - 自动评价';
    IndexController.template = 'rate/indexComment';
    IndexController.navClass = 'rateSetting';

    module.exports = IndexController;
});