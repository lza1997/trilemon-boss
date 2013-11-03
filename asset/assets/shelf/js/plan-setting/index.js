define(function(require, exports, module) {
    var NewController = require('./controller/new-controller');
    var FilterController = require('./controller/filter-controller');
    var EditController = require('./controller/edit-controller');
    var IndexController = require('./controller/index-controller');
    var DistributionController = require('./controller/distribution-controller');

    var PlanSettingForm = require('./service/plan-setting-form');
    var Confirm = require('./service/confirm');

    module.exports = {
        controllers: {
            'planSetting.new': NewController,
            'planSetting.filter': FilterController,
            'planSetting.index': IndexController,
            'planSetting.edit': EditController,
            'planSetting.distribution': DistributionController
        },
        factories: {
            'PlanSettingForm': PlanSettingForm,
            'Confirm': Confirm
        },
        filters: {
            'distributionText': require('./filter/distribution-text.js')
        },
        templates: {
            'planSetting/distribution': require('./template/distribution.html'),
            'planSetting/distributionModal': require('./template/distribution-modal.html'),
            'planSetting/chart': require('./template/chart.html'),
            'planSetting/confirm': require('./template/confirm.html'),
            'planSetting/filter': require('./template/filter.html'),
            'planSetting/form': require('./template/form.html'),
            'planSetting/index': require('./template/index.html')
        }
    };
});
