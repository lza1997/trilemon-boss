/**
 * distribution 是一种特殊的数据类型，用于标识周一至周日每天每个小时段的选择情况
 * 格式为 {1: {1:true, 2:false, ... , 23:true}, ...}
 */
angular.module('common').factory('DistributionFactory', ['$resource', '$http', function($resource, $http) {
    var DistributionFactory = {
        create: function(url) {
            return $resource(url, {id: '@id'}, {
                query: {
                    method: 'GET',
                    isArray: true,
                    transformResponse: $http.defaults.transformResponse.concat([function(data) {
                        // 服务器数据再组装
                        // 将 hash 变为 array [{ name:'周一', value:1, hours: {1:true, ...} }]
                        var arr = [];
                        var weeks = '周一 周二 周三 周四 周五 周六 周日'.split(' ');
                        _.each(weeks, function(v, index) {
                            var day = {name: v, value: index + 1};
                            day.hours = data[day.value];
                            day.checked = _.any(day.hours);
                            arr.push(day);
                        });
                        return arr;
                    }]),
                    interceptor: {
                        'response': function(response) {
                            var data = response.resource;

                            // 添加方法
                            _.each(data, function(day) {
                                day.toggleChecked = function() {
                                    if (!this.checked) {
                                        this.hours = {};
                                    }
                                };
                            });

                            return response.resource;
                        }
                    }
                },
                save: {
                    method: 'PUT',
                    transformRequest: function(data) {
                        // 保存时将 array 改回 hash
                        var hash = {};
                        _.each(data.distribution, function(day) {
                            hash[day.value] = day.hours;
                        });

                        return angular.toJson(hash);
                    }
                }
            });
        }
    };

    return DistributionFactory;
}]);