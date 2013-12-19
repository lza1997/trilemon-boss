/**
 * 海报的模块
 */
define(function(require, exports, module) {
    var poster = {
        controllers: {
            'poster.category': require('./controller/category'),
            'poster.selectTemplate': require('./controller/select-template')
        },
        factories: {
            'PosterCategory': require('./service/poster-category'),
            'PosterTopic': require('./service/poster-topic'),
            'PosterTemplate': require('./service/poster-template')
        },
        templates: {
            'poster/category': require('./template/category.html'),
            'poster/selectTemplate': require('./template/select-template.html')
        }
    };

    module.exports = poster;
});