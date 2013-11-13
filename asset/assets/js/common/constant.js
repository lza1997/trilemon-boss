/**
 * 常量表
 */
angular.module('common').constant({
    'PLAN_STATUS': {
        WAITING: 0,
        RUNNING: 1,
        PAUSED: 2
    },
    'SHOWCASE_SETTING_STATUS': {
        PAUSED: 1,
        RUNNING: 2
    },
    'SHOWCASE_ITEM_STATUS': {
        'SHOWCASE': 1,//一般规则
        'EXCLUDE': 2,//不推荐
        'INCLUDE': 3//固定推荐
    }
});