/**
 * 橱窗推荐应用的模块
 */
define(function(require, exports, module) {
    var showcase = {
        controllers: {
            'showcase.editSetting': require('./controller/edit-setting')
        },
        templates: {
            'showcase/editSetting': require('./template/edit-setting.html')
        }
    };

    module.exports = showcase;
});
