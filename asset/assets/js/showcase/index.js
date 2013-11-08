/**
 * 橱窗推荐应用的模块
 */
define(function(require, exports, module) {
    var showcase = {
        controllers: {
            'showcase.editRule': require('./controller/edit-rule')
        },
        templates: {
            'showcase/edit': require('./template/edit.html')
        }
    };

    module.exports = showcase;
});
