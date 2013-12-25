/**
 * 海报的模块
 */
define(function(require, exports, module) {
    var poster = {
        controllers: {
            'poster.category': require('./controller/category'),
            'poster.selectTemplate': require('./controller/select-template'),
            'poster.selectItem': require('./controller/select-item')
        },
        factories: {
            'PosterCategory': require('./service/poster-category'),
            'PosterTopic': require('./service/poster-topic'),
            'PosterTemplate': require('./service/poster-template'),
            'PosterRecommendTemplate': require('./service/poster-recommend-template'),
            'PosterItem': require('./service/poster-item')
        },
        filters: {
            'rowSplit': require('./filter/row-split')
        },
        templates: {
            'poster/category': require('./template/category.html'),
            'poster/selectTemplate': require('./template/select-template.html'),
            'poster/selectItem': require('./template/select-item.html')
        }
    };

    module.exports = poster;
});