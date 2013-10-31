define(function(require, exports, module) {
    var NewController = require('./controller/new-controller');
    var FilterController = require('./controller/filter-controller');
    var EditController = require('./controller/edit-controller');
    var IndexController = require('./controller/index-controller');
    var AdjustController = require('./controller/adjust-controller');

    var PlanSettingForm = require('./service/plan-setting-form');
    var Confirm = require('./service/confirm');

    module.exports = {
        controllers: {
            'planSetting.new': NewController,
            'planSetting.filter': FilterController,
            'planSetting.index': IndexController,
            'planSetting.edit': EditController,
            'planSetting.adjust': AdjustController
        },
        factories: {
            'PlanSettingForm': PlanSettingForm,
            'Confirm': Confirm
        },
        templates: {
            'planSetting/adjust': require('./template/adjust.html'),
            'planSetting/chart': require('./template/chart.html'),
            'planSetting/confirm': require('./template/confirm.html'),
            'planSetting/filter': require('./template/filter.html'),
            'planSetting/form': require('./template/form.html'),
            'planSetting/index': require('./template/index.html')
        }
    };
});
