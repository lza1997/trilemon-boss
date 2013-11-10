/**
 * 橱窗推荐应用的模块
 */
define(function(require, exports, module) {
    var showcase = {
        controllers: {
            'showcase.editSetting': require('./controller/edit-setting'),
            'showcase.indexShowcase': require('./controller/index-showcase')
        },
        templates: {
            'showcase/editSetting': require('./template/edit-setting.html'),
            'showcase/indexShowcase': require('./template/index-showcase.html')
        }
    };

    module.exports = showcase;
});
