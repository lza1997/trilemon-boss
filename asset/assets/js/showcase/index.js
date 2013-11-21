//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//
/**
 * 橱窗推荐应用的模块
 */
define(function(require, exports, module) {
    var showcase = {
        controllers: {
            'showcase.editSetting': require('./controller/edit-setting'),
            'showcase.indexShowcase': require('./controller/index-showcase'),
            'showcase.excludeItem': require('./controller/exclude-item'),
            'showcase.includeItem': require('./controller/include-item')
        },
        templates: {
            'showcase/editSetting': require('./template/edit-setting.html'),
            'showcase/indexShowcase': require('./template/index-showcase.html'),
            'showcase/excludeItem': require('./template/exclude-item.html'),
            'showcase/includeItem': require('./template/include-item.html')
        },
        factories: {
            'ShowcaseItemFactory': require('./service/showcase-item-factory'),
            'ShowcaseSetting': require('./service/showcase-setting')
        }
    };

    module.exports = showcase;
});
