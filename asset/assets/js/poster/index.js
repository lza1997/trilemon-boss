/**
 * 海报的模块
 */
define(function(require, exports, module) {
    var poster = {
        controllers: {
            'poster.category': require('./controller/category'),
            'poster.selectTemplate': require('./controller/select-template'),
            'poster.selectItem': require('./controller/select-item'),
            'poster.preview': require('./controller/preview'),
            'poster.publish': require('./controller/publish')
        },
        factories: {
            'PosterCategory': require('./service/poster-category'),
            'PosterTopic': require('./service/poster-topic'),
            'PosterTemplate': require('./service/poster-template'),
            'PosterRecommendTemplate': require('./service/poster-recommend-template'),
            'PosterItem': require('./service/poster-item'),
            'PosterSellerCat': require('./service/poster-sellercat'),
            'PosterActivity': require('./service/poster-activity')
        },
        directives: {
            'compileTemplate': require('./directive/compile-template')
        },
        filters: {
            'rowSplit': require('./filter/row-split'),
            'itemUrl': require('./filter/item-url'),
            'itemPicUrl': require('./filter/item-pic-url')
        },
        templates: {
            'poster/category': require('./template/category.html'),
            'poster/selectTemplate': require('./template/select-template.html'),
            'poster/selectItem': require('./template/select-item.html'),
            'poster/preview': require('./template/preview.html'),
            'poster/publish': require('./template/publish.html')
        }
    };

    module.exports = poster;
});