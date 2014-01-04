/**
 * 将一个数组根据 rowSize 切割为多个数组
 */
define(function(require, exports, module) {

    module.exports = function() {

        var split = function(array, rowSize) {
            var rows = [];
            angular.forEach(array, function(item, index) {
                var row = parseInt(index / rowSize, 10);
                if (!rows[row]) {
                    rows[row] = [];
                }
                rows[row].push(item);
            });
            //确保每行元素数目都达到 rowSize
            if (rows.length > 0) {
                var lastRowSize = rows[rows.length - 1].length;
                if (lastRowSize < rowSize) {
                    for (var i = 0; i < rowSize - lastRowSize; i++) {
                        rows[rows.length - 1].push({});
                    }
                }
            }

            return rows;
        };

        split = _.memoize(split, function(array, rowSize) {
            return angular.toJson(array) + rowSize;
        });

        return function(array, rowSize) {
            return split(array, rowSize);
        };
    };
});