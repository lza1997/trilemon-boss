define(function(require, exports, module) {
    module.exports = function() {

        function format(hour) {
            return hour + ":00";
        }

        // 将一组 hours 的 hash 转为字符
        // {0:true, 1: true, 3: false, 4:true} => 0:00~2:00, 4:00~5:00
        return function(hourHash) {
            var hours = [];

            // hash => [[1,2], [10,11]]
            _.each(hourHash, function(v, hour) {
                hour = parseInt(hour, 10);
                if (v) {
                    hours.push([hour, hour + 1]);
                }
            });

            // [[1,2], [2,3], [10, 11]]=> [[1,3], [10,11]]
            hours = _.reduce(hours, function(memo, hour) {
                var last = _.last(memo);
                if (last && last[1] === hour[0]) {
                    last[1] = hour[1];
                }
                else {
                    memo.push(hour);
                }
                return memo;
            }, []);

            // [[1,2], [3,4]] => ['1:00~2:00', '3:00~4:00']
            hours = _.map(hours, function(hour) {
                return format(hour[0]) + '~' + format(hour[1]);
            });

            return hours.join(' ');
        };
    };
});