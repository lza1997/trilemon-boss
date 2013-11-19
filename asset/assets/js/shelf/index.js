/**
 * 上下架应用的模块
 */
define(function(require, exports, module) {
    var shelf = {
        controllers: {
            'shelf.newPlanSetting': require('./controller/new-plan-setting'),
            'shelf.editPlanSetting': require('./controller/edit-plan-setting'),
            'shelf.indexPlanSetting': require('./controller/index-plan-setting'),
            'shelf.filter': require('./controller/filter'),
            'shelf.distribution': require('./controller/distribution')
        },
        factories: {
            'PlanSetting': require('./service/plan-setting'),
            'PlanItem': require('./service/plan-item'),
            'PlanSettingForm': require('./service/plan-setting-form'),
            'Confirm': require('./service/confirm')
        },
        filters: {
            'distributionText': require('./filter/distribution-text.js')
        },
        templates: {
            'shelf/distribution': require('./template/distribution.html'),
            'shelf/distributionModal': require('./template/distribution-modal.html'),
            'shelf/chart': require('./template/chart.html'),
            'shelf/confirm': require('./template/confirm.html'),
            'shelf/filter': require('./template/filter.html'),
            'shelf/form': require('./template/form.html'),
            'shelf/index': require('./template/index.html')
        }
    };

    module.exports = shelf;
});
